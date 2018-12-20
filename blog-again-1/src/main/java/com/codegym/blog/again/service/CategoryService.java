package com.codegym.blog.again.service;

import com.codegym.blog.again.model.Blog;
import com.codegym.blog.again.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);
}
