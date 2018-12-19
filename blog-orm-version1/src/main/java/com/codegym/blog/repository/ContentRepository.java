package com.codegym.blog.repository;

import com.codegym.blog.model.Content;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContentRepository extends PagingAndSortingRepository<Content, Long> {

}
