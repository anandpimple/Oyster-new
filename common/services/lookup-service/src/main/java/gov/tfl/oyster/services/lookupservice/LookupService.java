package gov.tfl.oyster.services.lookupservice;

import gov.tfl.oyster.common.domains.Loggable;

import java.util.List;

/**
 * Created by dev on 17/10/16.
 */
public interface LookupService extends Loggable{
    LookupVO getLookup(String name, String description);
    void refreshCache();
    List<LookupVO> getAllLooupsByType(String description);
}
