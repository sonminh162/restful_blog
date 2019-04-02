package com.codegym.cms.repository;

import com.codegym.cms.model.Blog;
import com.codegym.cms.model.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByCategory(Category category);
}
