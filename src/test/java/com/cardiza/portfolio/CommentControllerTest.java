package com.cardiza.portfolio;

import com.cardiza.portfolio.controller.CommentController;
import com.cardiza.portfolio.dto.CommentDto;
import com.cardiza.portfolio.service.CommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

import static com.cardiza.portfolio.config.ControllerNamings.ALL;
import static com.cardiza.portfolio.config.ControllerNamings.COMMENT;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CommentController.class)
class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentService commentService;

    private List<CommentDto> commentList;

    @BeforeEach
    void setUp() {
        commentList = IntStream.rangeClosed(1, 15)
                .mapToObj(i -> new CommentDto(
                        i,
                        "user" + i,
                        1,
                        "Comment " + i,
                        LocalDateTime.now().minusDays(15 - i)
                ))
                .toList();
    }

    @Test
    void getAllComments() throws Exception {
        Mockito.when(commentService.getAllComments()).thenReturn(commentList);

        mockMvc.perform(get(COMMENT + ALL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(commentList.size()));
    }

    @Test
    void getAllCommentsPaginated() throws Exception {
        List<CommentDto> pageContent = commentList.subList(0, 10);
        Page<CommentDto> page = new PageImpl<>(pageContent, PageRequest.of(0, 10), commentList.size());

        Mockito.when(commentService.getAllCommentsPaginated(anyInt(), anyInt(), anyString()))
                .thenReturn(page);

        mockMvc.perform(get(COMMENT))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(pageContent.size()));
    }
}