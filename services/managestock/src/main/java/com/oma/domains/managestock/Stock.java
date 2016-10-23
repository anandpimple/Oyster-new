/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oma.domains.managestock;

import com.oma.domains.BaseEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author anandpimple
 */
@Entity 
@Table(name="STOCKS")
public class Stock extends BaseEntity{
    private String name;
    private Collection<Product> products;
    @Column(name="STOCK_NAME", nullable = false,length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @ManyToMany
    @JoinTable(name = "STOCK_TO_PRODUCT",joinColumns=@JoinColumn(name="STOCK_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="PRODUCT_ID", referencedColumnName="ID"))
    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
