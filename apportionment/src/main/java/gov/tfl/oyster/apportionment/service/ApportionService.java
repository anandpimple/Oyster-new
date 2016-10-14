package gov.tfl.oyster.apportionment.service;

import gov.tfl.oyster.apportionment.domains.Apportionable;

/**
 * Created by dev on 14/10/16.
 */
public interface ApportionService {
    void apply(Apportionable apportionable);
}
