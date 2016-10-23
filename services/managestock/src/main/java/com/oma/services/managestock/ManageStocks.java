package com.oma.services.managestock;

import com.oma.domains.managestock.Product;
import com.oma.domains.managestock.Stock;
import java.util.List;

/**
 *
 * @author anandpimple
 */
public interface ManageStocks {
    List<Stock> getAllStock();
    Stock getStock(Product product);
}
