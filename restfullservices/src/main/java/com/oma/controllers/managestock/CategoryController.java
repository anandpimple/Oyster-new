package com.oma.controllers.managestock;

import com.oma.domains.managestock.Category;
import com.oma.repositories.managestock.CategoryRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author anandpimple
 */
@RestController
@RequestMapping(path = "/inventory/{custId}/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @RequestMapping( path = "")
    public @ResponseBody List<Category> listAll(@PathVariable  Long custId){
        return categoryRepository.findAll();
    }
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public @ResponseBody List<Category> add(@RequestBody Category category,@PathVariable  Long custId){
        categoryRepository.saveAndFlush(category);
        return categoryRepository.findAll();
    }

    @RequestMapping(path = "/{category}", method = RequestMethod.GET)
    public @ResponseBody Category byName(@PathVariable  Long custId, @PathVariable String category){
        Category category1 = new Category();
        category1.setName(category);
        return categoryRepository.findAll(Example.of(category1)).get(0);
    }

}
