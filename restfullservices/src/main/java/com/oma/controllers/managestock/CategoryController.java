package com.oma.controllers.managestock;

import com.oma.domains.managestock.Category;
import com.oma.repositories.managestock.CategoryRepository;
import com.oma.services.managestock.CategoryServiceImpl;
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
    private CategoryServiceImpl categoryService;
    @RequestMapping( path = "")
    public @ResponseBody List<Category> listAll(@PathVariable  Long custId){
        return categoryService.listAll();
    }
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public @ResponseBody List<Category> add(@RequestBody Category category,@PathVariable  Long custId){
        categoryService.addCategory(category);
        return categoryService.listAll();
    }

    @RequestMapping(path = "/{category}", method = RequestMethod.GET)
    public @ResponseBody Category byName(@PathVariable  Long custId, @PathVariable String category){
        return categoryService.getByName(category);
    }

}
