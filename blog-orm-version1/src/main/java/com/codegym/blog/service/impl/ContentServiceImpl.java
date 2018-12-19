package com.codegym.blog.service.impl;

import com.codegym.blog.model.Content;
import com.codegym.blog.repository.ContentRepository;
import com.codegym.blog.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;

public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Override
    public Iterable<Content> findAll() {
        return contentRepository.findAll();
    }

    @Override
    public Content findById(Long id) {
        return contentRepository.findOne(id);
    }

    @Override
    public void save(Content content) {
        contentRepository.save(content);
    }

    @Override
    public void remove(Long id) {
        contentRepository.delete(id);
    }
}
