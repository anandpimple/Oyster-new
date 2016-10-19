package gov.tfl.oyster.domains.lookupservice;


import gov.tfl.oyster.domains.common.AbstractBaseVO;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dev on 17/10/16.
 */

@Entity
@Table(name="TFL_LOOKUP_TYPE1")
public class LookupTypeVO extends AbstractBaseVO {
    private static final long serialVersionUID = -7505301198588550535L;
    private String description;
    private List<LookupVO> lookupVOs;
    public final static String MISC = "@unknown@";
    public final static String AUTOLOAD_CODES = "Autoload Codes";
    //public final static String AUTOLOAD_TRIALISTS = "Autoload Trialists";
    public final static String DISCOUNT_REASON = "Discount Reason";
    //public final static String EMAIL = "Email";
    public final static String PRESTIGE_ITEM_CODE = "External Prestige Item Code";
    public final static String HRF_CODES = "HRF Codes";
    public final static String INT_LUL_STATUS_CODE = "Internal LUL Status Code";
    public final static String ORDER_MODE  = "Order Mode";
    public final static String MERCHANT_ID = "Merchant ID";
    public final static String OYSTER_PASSWORD_TYPES = "Oyster Password Types";
    public final static String PRESTIGE_PAYMENT_METHOD = "Prestige Payment Method";
    public final static String REFUND_CODES = "Refund Codes";
    public final static String REFUND_METHOD = "Refund Methods";
    public final static String SHIPPING_METHOD = "Shipping Method";
    public final static String SITE_MESSAGES = "Site Messages";
    public final static String START_DATE = "Start Date";
    public final static String CUSTOMER_TITLES = "Customer Titles";
    //public final static String CONTENT_MESSAGES = "Content Messages";
    public final static String CONFIGURATION = "Configuration";
    public final static String BARCLAYCARD_BIN_RANGES = "Barclaycard BIN Ranges";
    public final static String REPORTING = "Reporting";
    public final static String ORS_REFERENCE_DATA = "ORS Reference Data";
    public final static String BLACKLISTED_EMAIL = "Blacklisted Email";
    public final static String SDR_REFERENCE_DATA = "SDR";
    public final static String CSTP_REFERENCE_DATA = "CSTP";
    public final static String REFUND_LIMITS = "Refund Limits";
    public static final String DATA_MIGRATION = "Data Migration";

    public final static String JOURNEY_HISTORY_CHECK = "Journey History Check";

    public final static String SSR_REFUND = "ssr_refund";
    public final static String BATCH_SCHEDULER = "BATCH_SCHEDULER";
    public final static String Cubic = "Cubic";
    public final static String WS_ACTIVE = "WS_ACTIVE";


    /**
     * @return the description
     */
    @Column(name="DESCR")
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the lookupVOs
     */

    @OneToMany(fetch= FetchType.EAGER)
    @JoinColumn(name="LOOKUP_TYPE_ID",referencedColumnName="ID") //column on lookup
    public List<LookupVO> getLookupVOs() {
        return lookupVOs;
    }
    /**
     * @param lookupVOs the lookupVOs to set
     */
    public void setLookupVOs(List<LookupVO> lookupVOs) {
        this.lookupVOs = lookupVOs;
    }
}
