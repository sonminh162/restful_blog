package com.codegym.cms.service;

import com.codegym.cms.model.Category;
import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void remove(int id);

}
