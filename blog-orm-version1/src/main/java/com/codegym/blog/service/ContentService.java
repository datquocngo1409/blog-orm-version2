package com.codegym.blog.service;

import com.codegym.blog.model.Content;

public interface ContentService {
    Iterable<Content> findAll();

    Content findById(Long id);

    void save(Content content);

    void remove(Long id);
}
