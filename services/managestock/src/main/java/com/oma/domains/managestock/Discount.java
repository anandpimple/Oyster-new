package com.oma.domains.managestock;

import com.oma.domains.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by dev on 26/10/16.
 */
@Entity
@Table(name = "DISCOUNTS")
@SequenceGenerator(name = "ID_GENRATOR",initialValue = 1,sequenceName = "DISCOUNTS_SEQ")
public class Discount extends BaseEntity{
    private String description;

    @Column(name = "DESCRIPTION",length = 100, nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
