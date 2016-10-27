package com.oma.domains.managestock;

import com.oma.domains.BaseEntity;

import javax.persistence.*;

/**
 * Created by dev on 26/10/16.
 */
@Entity
@Table(name = "PROPERTIES")
@SequenceGenerator(name = "ID_GENRATOR",initialValue = 1,sequenceName = "PROPERTIES_SEQ")
public class Property extends BaseEntity {
    public enum PropertyType {
        INTEGER,LONG,DECIMAL,BIGDECIMAL,FLOAT,STRING;
    }
    private String name;
    private PropertyType type;
    private boolean mandatory;

    @Column(name="PRODUCT_NAME", nullable = false,length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "TYPE",length = 55,nullable = false)
    @Enumerated(EnumType.STRING)
    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    @Column(name = "IS_REQUIRED")
    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }
}
