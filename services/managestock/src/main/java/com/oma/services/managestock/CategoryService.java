package com.oma.services.managestock;

import com.oma.domains.managestock.Category;

import java.util.List;

/**
 * Created by dev on 02/11/16.
 */
public interface CategoryService {
    Category addCategory(Category cat);
    List<Category> listAll();
    Category getByName(String categoryName);
}
