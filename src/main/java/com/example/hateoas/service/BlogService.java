package com.example.hateoas.service;

import com.example.hateoas.domain.Blog;
import com.example.hateoas.repository.BlogRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {

    @Resource
    BlogRepository repository;

    public List<Blog> selectBlogList() {
        return repository.findAll();
    }

    public Blog selectBlog(int id) {
        return repository.findById(id);
    }

    public Blog insertBlog(Blog blog) {
        blog.setCreatedDate(new Date());
        return repository.save(blog);
    }

    public Blog updateBlog(Blog blog) {
        return repository.save(blog);
    }

    public void deleteBlog(int id) {
        repository.deleteById(id);
    }
}
