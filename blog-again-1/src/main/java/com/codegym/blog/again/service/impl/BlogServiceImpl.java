package com.codegym.blog.again.service.impl;

import com.codegym.blog.again.model.Blog;
import com.codegym.blog.again.repository.BlogRepository;
import com.codegym.blog.again.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByFirstNameContaining(String name, Pageable pageable) {
        return blogRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public void save(Blog model) {
        blogRepository.save(model);
    }
    @Override
    public void remove(Long id) {
        blogRepository.delete(id);
    }
}
