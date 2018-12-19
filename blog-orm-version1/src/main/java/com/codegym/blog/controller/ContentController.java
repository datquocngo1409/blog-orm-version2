package com.codegym.blog.controller;

import com.codegym.blog.model.Content;
import com.codegym.blog.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping("contents")
    public ModelAndView listContent(){
        Iterable<Content> contents = contentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/content/list");
        modelAndView.addObject("contents", contents);
        return modelAndView;
    }
}
