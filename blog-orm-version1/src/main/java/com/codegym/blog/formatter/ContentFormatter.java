package com.codegym.blog.formatter;

import com.codegym.blog.model.Content;
import com.codegym.blog.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ContentFormatter implements Formatter<Content> {
    private ContentService contentService;

    @Autowired
    public ContentFormatter(ContentService contentService){
        this.contentService = contentService;
    }

    @Override
    public Content parse(String text, Locale locale) throws ParseException {
        return contentService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Content object, Locale locale) {
        return "[" + object.getId() + ", " +object.getContent() + "]";
    }
}
