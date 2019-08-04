package com.example.hateoas.repository;

import com.example.hateoas.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByBlogId(int blogId);
    Comment findById(int id);
}
