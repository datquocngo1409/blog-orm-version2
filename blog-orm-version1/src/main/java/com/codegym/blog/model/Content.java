package com.codegym.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "contents")
public class Content {

    @Id
    @GeneratedValue
    Long id;
    String content;

    @OneToOne(targetEntity = Blog.class)
    private Blog blog;

    public Content() {
    }

    public Content(String content, Blog blog) {
        this.content = content;
        this.blog = blog;
    }

    public Content(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
