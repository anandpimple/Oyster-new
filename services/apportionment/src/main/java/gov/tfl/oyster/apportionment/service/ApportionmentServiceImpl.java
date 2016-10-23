package gov.tfl.oyster.apportionment.service;

import gov.tfl.oyster.apportionment.domains.Apportionable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by anandpimple on 14/10/2016.
 */
@Service
@Qualifier("apportionmentServiceImpl")
public class ApportionmentServiceImpl implements ApportionService {

    public void apply(Apportionable apportionable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
