package com.blog.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.app.entities.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
