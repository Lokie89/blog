package com.example.hateoas.controller;

import com.example.hateoas.domain.Blog;
import com.example.hateoas.properties.Description;
import com.example.hateoas.properties.MandatoryData;
import com.example.hateoas.properties.OptionalData;
import com.example.hateoas.service.BlogService;
import com.example.hateoas.util.Hateoas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "${endpoint.blog}")
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    MandatoryData mandatoryData;

    @Autowired
    OptionalData optionalData;

    @Autowired
    Description description;

    private ResponseEntity responseOK(HttpServletRequest request, Blog blog) {
        if (blog != null) {
            blog.set_links(Hateoas.hateoasCRUD(request, mandatoryData.getBlog(), optionalData.getBlog(), blog.getId(), false, description.getBlog()));
        }
        return new ResponseEntity(blog, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List> getBlogList(HttpServletRequest request) {
        List<Blog> blogList = blogService.selectBlogList();
        for (Blog blog : blogList) {
            blog.set_links(Hateoas.hateoasCRUD(request, mandatoryData.getBlog(), optionalData.getBlog(), blog.getId(), true, description.getBlog()));
        }

        return new ResponseEntity(blogList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity postBlog(HttpServletRequest request, Blog blog) {
        //validation
        blogService.insertBlog(blog);
        return responseOK(request, blog);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlog(HttpServletRequest request, @PathVariable int id) {
        System.out.print("$$$$$");
        Blog blog = blogService.selectBlog(id);
        return responseOK(request, blog);
    }

    @PutMapping("/{id}")
    public ResponseEntity putBlog(HttpServletRequest request, Blog blog) {
        System.out.print("#####");
        if (blogService.selectBlog(blog.getId()) == null) {
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
        blog.setId(blog.getId());
        System.out.println(blog);
        blogService.updateBlog(blog);
        return responseOK(request, blog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBlog(HttpServletRequest request, @PathVariable int id) {
        blogService.deleteBlog(id);
        return responseOK(request, null);
    }


}
