package com.cardiza.portfolio.controller;

import com.cardiza.portfolio.dto.CommentDto;
import com.cardiza.portfolio.service.CommentService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.cardiza.portfolio.config.ApplicationValues.*;
import static com.cardiza.portfolio.config.ControllerNamings.ALL;
import static com.cardiza.portfolio.config.ControllerNamings.COMMENT;

@RestController
@RequestMapping(COMMENT)
@RequiredArgsConstructor
public class CommentController {

    @NonNull
    private final CommentService commentService;

    @GetMapping(ALL)
    public List<CommentDto> getAllComments() {
        return this.commentService.getAllComments();
    }

    @GetMapping
    public Page<CommentDto> getAllCommentsPaginated(
            @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int size,
            @RequestParam(defaultValue = DEFAULT_SORT_BY) String sortBy
    ) {
        return this.commentService.getAllCommentsPaginated(page, size, sortBy);
    }
}
