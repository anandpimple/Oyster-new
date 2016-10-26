package com.oma.domains.managestock;

import com.oma.domains.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by dev on 26/10/16.
 */
@Entity
@Table(name = "ITEMS")
public class Item extends BaseEntity{
    private LocalDateTime dateOfProduction;
    private Product product;
    private Collection<Item> subitems;
    private BigDecimal purchasePrice;
    private BigDecimal sellsPrice;
    private BigDecimal baseSellPrice;
    private Item parentItem;
    private Order order;
    private Collection<Discount>  discounts;
    private Collection<ItemProductPropertyValue>  propertyValue;

    @Column(name = "PRODUCTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(LocalDateTime dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Collection<Item> getSubitems() {
        return subitems;
    }

    public void setSubitems(Collection<Item> subitems) {
        this.subitems = subitems;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    public Item getParentItem() {
        return parentItem;
    }

    public void setParentItem(Item parentItem) {
        this.parentItem = parentItem;
    }

    @Column(name = "PURCHASE_PRICE",nullable = false)
    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    @Column(name = "SALES_PRICE")
    public BigDecimal getSellsPrice() {
        return sellsPrice;
    }

    public void setSellsPrice(BigDecimal sellsPrice) {
        this.sellsPrice = sellsPrice;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Column(name = "BASE_SALES_PRICE",nullable = false)
    public BigDecimal getBaseSellPrice() {
        return baseSellPrice;
    }

    public void setBaseSellPrice(BigDecimal baseSellPrice) {
        this.baseSellPrice = baseSellPrice;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ITEM_TO_DISCOUNTS",joinColumns=@JoinColumn(name="ORDER_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="DISCOUNT_ID", referencedColumnName="ID"))
    public Collection<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Collection<Discount> discounts) {
        this.discounts = discounts;
    }

}