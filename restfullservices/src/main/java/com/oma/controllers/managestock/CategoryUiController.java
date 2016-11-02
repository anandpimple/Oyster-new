package com.oma.controllers.managestock;

import com.oma.domains.managestock.Category;
import com.oma.services.managestock.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dev on 02/11/16.
 */
@Controller
@RequestMapping("/inventory/category")
public class CategoryUiController {
    @Autowired
    private CategoryServiceImpl categoryService;
    @RequestMapping("/add/process")
    public ModelAndView addCategory(@RequestBody Category cat){
        Map<String,Object> models = new HashMap<>();
        categoryService.addCategory(cat);
        models.put("Categories",categoryService.listAll());
        return new ModelAndView("listAllCategories",models);
    }
    @RequestMapping("/add/input")
    public String inputCategory(Model model){
        model.addAttribute("Category",new Category());
        return "addCategoryInputForm";
    }
}
