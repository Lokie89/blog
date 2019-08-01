package com.example.hateoas.service;

import com.example.hateoas.domain.Blog;
import com.example.hateoas.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogRepository repository;

    public List<Blog> getBlogList(){
        return repository.findAll();
    }
}
