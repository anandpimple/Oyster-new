package gov.tfl.oyster.restservices.controllers.lookupservice;

import gov.tfl.oyster.common.domains.Loggable;
import gov.tfl.oyster.services.lookupservice.LookupService;
import gov.tfl.oyster.services.lookupservice.LookupServiceImpl;
import gov.tfl.oyster.services.lookupservice.LookupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * Created by dev on 17/10/16.
 */
@RestController
@RequestMapping("/lookupservice")
public class LookupServiceController implements Loggable {
    @Autowired
    private LookupService lookupService;
    @RequestMapping("/refresh")
    public @ResponseBody String refresh(){
        debug("Refreshing lookup cache",null);
        lookupService.refreshCache();
        return "Refreshed";
    }

    @RequestMapping("/{typeName}/{name}")
    public @ResponseBody
    LookupVO getLookup(@PathVariable("name") String name, @PathVariable("typeName") String typeName ){
        debug(String.format("Getting lookup for %1 of type %2", new String[]{name,typeName}),null);
        return lookupService.getLookup(name,typeName);
    }

    public Logger getLogger() {
        return Logger.getLogger(this.getClass().getName());
    }


}
