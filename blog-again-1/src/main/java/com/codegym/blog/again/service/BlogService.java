package com.codegym.blog.again.service;

import com.codegym.blog.again.model.Blog;
import com.codegym.blog.again.repository.BlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByFirstNameContaining(String firstname, Pageable pageable);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);
}
