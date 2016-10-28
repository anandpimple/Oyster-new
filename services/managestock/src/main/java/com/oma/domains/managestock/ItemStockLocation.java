package com.oma.domains.managestock;

import com.oma.domains.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by anandpimple on 27/10/2016.
 */
@Entity
@Table(name = "ITEM_STOCK_LOCATIONS")
@SequenceGenerator(name = "ID_GENRATOR",initialValue = 1,sequenceName = "ITEM_STOCK_LOCATIONS_SEQ")
public class ItemStockLocation extends BaseEntity{
    private Item item;
    private Date stockedSince;
    private Date removedOn;
    private StockLocation stockLocation;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID",referencedColumnName = "ID")
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Column(name="STOCKED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getStockedSince() {
        return stockedSince;
    }

    public void setStockedSince(Date stockedSince) {
        this.stockedSince = stockedSince;
    }

    @Column(name="STOCKED_OFF")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getRemovedOn() {
        return removedOn;
    }

    public void setRemovedOn(Date removedOn) {
        this.removedOn = removedOn;
    }

    @ManyToOne
    @JoinColumn(name="LOCATION_ID",referencedColumnName = "ID")
    public StockLocation getStockLocation() {
        return stockLocation;
    }

    public void setStockLocation(StockLocation stockLocation) {
        this.stockLocation = stockLocation;
    }
}
