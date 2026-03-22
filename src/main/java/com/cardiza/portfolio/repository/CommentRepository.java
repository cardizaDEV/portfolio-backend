package com.cardiza.portfolio.repository;

import com.cardiza.portfolio.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
