package com.cardiza.portfolio.service.impl;

import com.cardiza.portfolio.dto.CommentDto;
import com.cardiza.portfolio.entity.Comment;
import com.cardiza.portfolio.mapper.GenericMapper;
import com.cardiza.portfolio.repository.CommentRepository;
import com.cardiza.portfolio.service.CommentService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    @NonNull
    private final GenericMapper genericMapper;
    @NonNull
    private final CommentRepository commentRepository;

    @Override
    @Cacheable("comments")
    public List<CommentDto> getAllComments() {
        return this.commentRepository.findAll()
                .stream()
                .map(this.genericMapper::commentToDto)
                .toList();
    }

    @Override
    @Cacheable(value = "comments", key = "#page + '-' + #size + '-' + #sortBy")
    public Page<CommentDto> getAllCommentsPaginated(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        Page<Comment> commentPage = commentRepository.findAll(pageable);
        List<CommentDto> dtoList = commentPage.getContent()
                .stream()
                .map(genericMapper::commentToDto)
                .toList();
        return new PageImpl<>(dtoList, pageable, commentPage.getTotalElements());
    }
}
