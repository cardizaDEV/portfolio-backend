package com.cardiza.portfolio.service;

import com.cardiza.portfolio.dto.CommentDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommentService {
    List<CommentDto> getAllComments();

    Page<CommentDto> getAllCommentsPaginated(int page, int size, String sortBy);
}
