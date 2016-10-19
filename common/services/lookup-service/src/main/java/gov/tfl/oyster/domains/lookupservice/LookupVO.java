package gov.tfl.oyster.domains.lookupservice;

import gov.tfl.oyster.domains.common.AbstractBaseVO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by dev on 17/10/16.
 */
@Entity
@Table(name="TFL_LOOKUP1")
public class LookupVO extends AbstractBaseVO{
    private static final long serialVersionUID = 8652833103938993254L;

    private String name;
    private String value;
    private Integer typeID;
    private String create_date;
    private String last_modified;

    @Column(name="NAME")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = (String)name;
    }

    @Column(name="VALUE")
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = (String)value;
    }

    @Column(name="LOOKUP_TYPE_ID")
    public Integer getTypeID() {
        return this.typeID;
    }

    public void setTypeID(Integer typeId) {
        this.typeID = typeId;
    }
}
