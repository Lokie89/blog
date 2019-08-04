package com.example.hateoas.controller;

import com.example.hateoas.domain.Blog;
import com.example.hateoas.domain.Comment;
import com.example.hateoas.properties.Description;
import com.example.hateoas.properties.MandatoryData;
import com.example.hateoas.properties.OptionalData;
import com.example.hateoas.service.CommentService;
import com.example.hateoas.util.Hateoas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "${endpoint.comment}")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    MandatoryData mandatoryData;

    @Autowired
    OptionalData optionalData;

    @Autowired
    Description description;

    private ResponseEntity responseOK(HttpServletRequest request, Comment comment) {
        if (comment != null) {
            comment.set_links(Hateoas.hateoasCRUD(request, mandatoryData.getComment(), optionalData.getComment(), comment.getId(), false, description.getComment()));
        }
        return new ResponseEntity(comment, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List> getCommentList(HttpServletRequest request, @PathVariable int blogId) {
        List<Comment> commentList = commentService.selectCommentList(blogId);
        for (Comment comment : commentList) {
            comment.set_links(Hateoas.hateoasCRUD(request, mandatoryData.getComment(), optionalData.getComment(), comment.getId(), true, description.getComment()));
        }
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity setComment(HttpServletRequest request, Comment comment) {
        System.out.println(comment);
        commentService.insertComment(comment);
        return responseOK(request, comment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlog(HttpServletRequest request, @PathVariable int id) {
        Comment comment = commentService.selectComment(id);
        return responseOK(request, comment);
    }

    @PutMapping("/{id}")
    public ResponseEntity modifyBlog(HttpServletRequest request, Comment comment) {
        if (commentService.selectComment(comment.getId()) == null) {
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
        commentService.updateComment(comment);
        return responseOK(request, comment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeBlog(HttpServletRequest request, @PathVariable int id) {
        commentService.deleteComment(id);
        return responseOK(request, null);
    }


}
