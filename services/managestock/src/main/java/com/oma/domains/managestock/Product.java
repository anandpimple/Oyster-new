/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oma.domains.managestock;

import com.oma.domains.BaseEntity;

import javax.persistence.*;
import java.util.Collection;

/**
 *
 * @author anandpimple
 */
@Entity
@Table(name = "PRODUCTS")
@SequenceGenerator(name = "ID_GENRATOR",initialValue = 1,sequenceName = "PRODUCTS_SEQ")
public class Product extends BaseEntity{
    private String name;
    private Collection<Property> properties;

    @Column(name="PRODUCT_NAME", nullable = false,length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PRODUCT_TO_PROPERTY",joinColumns=@JoinColumn(name="PRODUCT_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="PROPERTY_ID", referencedColumnName="ID"))
    public Collection<Property> getProperties() {
        return properties;
    }

    public void setProperties(Collection<Property> properties) {
        this.properties = properties;
    }
}
