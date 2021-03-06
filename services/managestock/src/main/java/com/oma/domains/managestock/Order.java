package com.oma.domains.managestock;

import com.oma.domains.BaseEntity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by dev on 26/10/16.
 */
@Entity
@Table(name = "ORDERS")
@SequenceGenerator(name = "ID_GENRATOR",initialValue = 1,sequenceName = "ORDERS_SEQ")
public class Order extends BaseEntity{
    public enum OrderType{
        PURCHASE,SALE,INTERNAL
    }
    public enum OrderStatus{
        INIT,NEW,IN_PROCESS,CANCELLED,FAILED,FRAUD,DUPLICATE,REJECTED,DESPATCHED,RECIEVED,COMPLETE,NOT_RECIEVED,LOST,REFUNDED
    }
    private Collection<Item> items;
    private Collection<Discount> discounts;
    private OrderType type;
    private OrderStatus status;

    @OneToMany(cascade = CascadeType.ALL)
    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ORDER_TO_DISCOUNTS",joinColumns=@JoinColumn(name="ORDER_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="DISCOUNT_ID", referencedColumnName="ID"))
    public Collection<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Collection<Discount> discounts) {
        this.discounts = discounts;
    }
    @Column(name = "TYPE",length = 55,nullable = false)
    @Enumerated(EnumType.STRING)
    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    @Column(name = "STATUS",length = 55,nullable = false)
    @Enumerated(EnumType.STRING)
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
