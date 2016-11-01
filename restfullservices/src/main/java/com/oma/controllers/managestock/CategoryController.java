package com.oma.controllers.managestock;

import com.oma.domains.managestock.Category;
import com.oma.repositories.managestock.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author anandpimple
 */
@RestController
@RequestMapping(path = "/inventory")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @RequestMapping(path = "/categories")
    public @ResponseBody List<Category> listAll(){
        return categoryRepository.findAll();
    }
    @RequestMapping(path = "/categories/add", method = RequestMethod.POST)
    public @ResponseBody List<Category> add(@RequestBody Category category){
        categoryRepository.saveAndFlush(category);
        return categoryRepository.findAll();
    }

}
