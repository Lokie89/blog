package com.example.hateoas.service;

import com.example.hateoas.domain.Comment;
import com.example.hateoas.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Resource
    CommentRepository repository;

    public List<Comment> selectCommentList(int blogId) {
        return repository.findAllByBlogId(blogId);
    }

    public Comment selectComment(int id) {
        return repository.findById(id);
    }

    public Comment insertComment(Comment comment) {
        comment.setCreatedDate(new Date());
        return repository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        return repository.save(comment);
    }

    public void deleteComment(int id) {
        repository.deleteById(id);
    }
}
