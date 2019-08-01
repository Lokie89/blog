package com.example.hateoas.controller;

import com.example.hateoas.domain.Blog;
import com.example.hateoas.repository.BlogRepository;
import com.example.hateoas.service.BlogService;
import com.example.hateoas.util.Hateoas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping("/blog")
    public ResponseEntity<List> getBlogList(HttpServletRequest request) {
        List<Blog> blogList = blogService.getBlogList();

        for (Blog b : blogList) {
//            b.set_links(Hateoas.hateoasableList(request, b.getId()));
        }

        return new ResponseEntity<List>(blogList, HttpStatus.OK);
    }

    @RequestMapping("/blog/{blogId}")
    public ResponseEntity<Blog> getBlog(HttpServletRequest request, @PathVariable String blogId) {
        Blog blog = new Blog();
        long id = Long.parseLong(blogId);
//        blog.set_links(Hateoas.hateoasableOne(request));
        return new ResponseEntity(blog, HttpStatus.OK);
    }


}
