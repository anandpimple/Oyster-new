package com.oma.controllers.managestock;

import com.oma.domains.managestock.Category;
import com.oma.repositories.managestock.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author anandpimple
 */
@RestController
@RequestMapping(path = "/stock")
public class ManageStockController {
    @Autowired
    private CategoryRepository categoryRepository;
    @RequestMapping(path = "/categories")
    public @ResponseBody List<Category> manage(){
        return categoryRepository.findAll();
    }
}
