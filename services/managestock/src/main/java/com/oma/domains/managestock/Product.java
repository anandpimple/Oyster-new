/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oma.domains.managestock;

import com.oma.domains.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author anandpimple
 */
@Entity
@Table(name = "PRODUCTS")
public class Product extends BaseEntity{
    private String name;
    @Column(name="PRODUCT_NAME", nullable = false,length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
