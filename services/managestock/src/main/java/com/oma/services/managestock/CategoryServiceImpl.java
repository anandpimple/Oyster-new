package com.oma.services.managestock;

import com.oma.domains.managestock.Category;
import com.oma.repositories.managestock.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by dev on 02/11/16.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category cat) {
        if(null != cat)
            return categoryRepository.save(cat);
        else
            throw new IllegalArgumentException("Category can't be null");
    }

    @Override
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getByName(String categoryName) {
        if(null == categoryName || categoryName.trim().length() == 0)
            throw new IllegalArgumentException("Category can't be null");
        Category category1 = new Category();
        category1.setName(categoryName);
        List<Category> catList = categoryRepository.findAll(Example.of(category1));
        return catList.isEmpty()?null:catList.get(0);
    }
}
