package gov.tfl.oyster.services.lookupservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by dev on 17/10/16.
 */
@Service
@Qualifier(value = "lookupServiceImpl")
public class LookupServiceImpl implements LookupService {
    private final static Logger logger = Logger.getLogger(LookupServiceImpl.class.getName());
    public HashMap<String, LookupTypeVO> lookupCache = new HashMap<String, LookupTypeVO>();
    @Autowired
    private LookupRepository lookupRepository;

    public LookupVO getLookup(String name, String description) {
        debug(String.format("Getting lookup %1 of type %2", new String[]{name,description}),null);
        return lookupCache.get(description).getLookupVOs().parallelStream().filter(value -> {
            debug("Lookup in cache is " + value.getName(), null);
            return value.getName().equals(name.trim());
        }).findFirst().orElse(null);
    }

    public void refreshCache() {
        debug("Refreshing cache",null);
        lookupCache.clear();
        lookupRepository.findAll().parallelStream().forEach(value -> lookupCache.put(value.getDescription(), value));
    }

    @Override
    public List<LookupVO> getAllLooupsByType(String description) {
        debug("Getting lookups for type "+description,null);
        return lookupCache.get(description).getLookupVOs();
    }

    @Override
    public Logger getLogger() {
        return Logger.getLogger(this.getClass().getName());
    }

    public LookupRepository getLookupRepository() {
        return lookupRepository;
    }

    public void setLookupRepository(LookupRepository lookupRepository) {
        this.lookupRepository = lookupRepository;
    }
}
