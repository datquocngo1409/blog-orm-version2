package com.codegym.blog.again.controller;

import com.codegym.blog.again.model.Blog;
import com.codegym.blog.again.model.Category;
import com.codegym.blog.again.service.BlogService;
import com.codegym.blog.again.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/blogs")
    public ModelAndView showListBlogs(@PageableDefault(size = 3) Pageable pageable, @RequestParam("s")Optional<String> s){
        Page<Blog> blogs;
        if (s.isPresent()){
            blogs = blogService.findAllByFirstNameContaining(s.get(), pageable);
        }else blogs = blogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("create-blog")
    public ModelAndView showCreateBlog(){
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("create-blog")
    public ModelAndView createBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("message", "Created Blog successfully");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @GetMapping("edit-blog/{id}")
    public ModelAndView showEditBlog(@PathVariable("id") Long id){
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView =  new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("edit-blog")
    public ModelAndView editBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView =  new ModelAndView("/blog/edit");
        modelAndView.addObject("message", "Edit Blog successfully!");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @GetMapping("delete-blog/{id}")
    public ModelAndView showDeleteBlog(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blog/delete");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("delete-blog")
    public String deleteBlog(@ModelAttribute("blog") Blog blog){
        blogService.remove(blog.getId());
        return "redirect:blogs";
    }
}
