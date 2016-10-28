package com.oma.domains.managestock;

import com.oma.domains.BaseEntity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by anandpimple on 27/10/2016.
 */
@Entity
@Table(name = "CATEGORIES")
@SequenceGenerator(name = "ID_GENRATOR",initialValue = 1,sequenceName = "CATEGORIES_SEQ")
public class Category extends BaseEntity {
    private String name;
    private Category parent;
    private Collection<Category> childCategories;
    private Collection<Product> products;

    @Column(name = "NAME",length = 100,unique = true,nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    @ManyToOne
    @JoinColumn(name = "PARENT_ID",referencedColumnName = "ID")
    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    @OneToMany
    @JoinColumn(name = "ID",referencedColumnName = "PARENT_ID")
    public Collection<Category> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(Collection<Category> childCategories) {
        this.childCategories = childCategories;
    }

    @OneToMany
    @JoinColumn(name = "CATEGORY_ID",referencedColumnName = "ID")
    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
