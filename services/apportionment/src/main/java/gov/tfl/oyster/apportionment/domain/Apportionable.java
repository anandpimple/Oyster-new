package gov.tfl.oyster.apportionment.domain;

import java.math.BigDecimal;

/**
 * Created by dev on 14/10/16.
 */
public interface Apportionable {
    String getGroupName();
    BigDecimal getAmount();
    Long getApportionableId();
    Long getApportionableType();
    Long getAppId();
}
