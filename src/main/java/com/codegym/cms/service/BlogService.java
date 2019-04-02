package com.codegym.cms.service;

import com.codegym.cms.model.Blog;
import com.codegym.cms.model.Category;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void remove(int id);

    List<Blog> findAllByCategory(Category category);
}
