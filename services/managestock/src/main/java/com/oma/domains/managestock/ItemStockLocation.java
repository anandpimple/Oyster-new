package com.oma.domains.managestock;

import com.oma.domains.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by anandpimple on 27/10/2016.
 */
@Entity
@Table(name = "ITEM_STOCK_LOCATIONS")
public class ItemStockLocation extends BaseEntity{
    private Item item;
    private Date stockedSince;
    private Date removedOn;
    private StockLocation stockLocation;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Date getStockedSince() {
        return stockedSince;
    }

    public void setStockedSince(Date stockedSince) {
        this.stockedSince = stockedSince;
    }

    public Date getRemovedOn() {
        return removedOn;
    }

    public void setRemovedOn(Date removedOn) {
        this.removedOn = removedOn;
    }

    public StockLocation getStockLocation() {
        return stockLocation;
    }

    public void setStockLocation(StockLocation stockLocation) {
        this.stockLocation = stockLocation;
    }
}
