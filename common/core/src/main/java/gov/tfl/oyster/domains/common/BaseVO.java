package gov.tfl.oyster.domains.common;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Transient;

/**
 * Created by dev on 17/10/16.
 */
public interface BaseVO extends Serializable {
    /**
     * Checks whether New record
     *
     * @return <code>true</code> if the prestigeId is null;
     * <code>false</code> if the prestigeId is not null.
     */
    @Transient
    boolean isNew();

    default LocalDateTime generateBaseVoCreateDate(){
         return LocalDateTime.now();
    }
}
