package com.oma.domains.managestock;

import com.oma.domains.BaseEntity;

import javax.persistence.*;

/**
 * Created by dev on 26/10/16.
 */
@Entity
@Table(name = "ITEM_PRODUCT_PROPERTY_VALUE")
@SequenceGenerator(name = "ID_GENRATOR",initialValue = 1,sequenceName = "ITEM_PRODUCT_PROPERTY_VALUE_SEQ")
public class ItemProductPropertyValue extends BaseEntity{
    private Property productPropert;
    private String value;
    private Item item;

    @OneToOne
    @JoinColumn(name = "PROPERTY_ID")
    public Property getProductPropert() {
        return productPropert;
    }

    public void setProductPropert(Property productPropert) {
        this.productPropert = productPropert;
    }
    @Column(name = "VALUE")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
