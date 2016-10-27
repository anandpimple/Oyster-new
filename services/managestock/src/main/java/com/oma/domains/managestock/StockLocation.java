package com.oma.domains.managestock;

import com.oma.domains.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by dev on 27/10/16.
 */
@Entity
@Table(name = "STOCK_LOCATIONS")
@SequenceGenerator(name = "ID_GENRATOR",initialValue = 1,sequenceName = "STOCK_LOCATIONS_SEQ")
public class StockLocation extends BaseEntity {

    private Stock sock;
    private StockLocation parentSockLocation;

    @ManyToOne
    @JoinColumn(name = "STOCK_ID")
    public Stock getSock() {
        return sock;
    }

    public void setSock(Stock sock) {
        this.sock = sock;
    }

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public StockLocation getParentSockLocation() {
        return parentSockLocation;
    }

    public void setParentSockLocation(StockLocation parentSockLocation) {
        this.parentSockLocation = parentSockLocation;
    }
}
