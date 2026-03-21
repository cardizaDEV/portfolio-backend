package com.cardiza.portfolio;

import com.cardiza.portfolio.controller.TechnologyController;
import com.cardiza.portfolio.dto.TechnologyCategoryDto;
import com.cardiza.portfolio.dto.TechnologyDto;
import com.cardiza.portfolio.service.TechnologyService;
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

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static com.cardiza.portfolio.config.ControllerNamings.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TechnologyController.class)
class TechnologyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TechnologyService technologyService;

    private List<TechnologyDto> techList;

    @BeforeEach
    void setUp() {
        TechnologyCategoryDto backendCategory = new TechnologyCategoryDto(
                1, "Backend", "#FEF0DC", "#7A3E00", "#F9C47A"
        );

        techList = IntStream.rangeClosed(1, 15)
                .mapToObj(i -> new TechnologyDto(
                        i,
                        "Technology " + i,
                        "https://url" + i + ".com",
                        Set.of(backendCategory)
                ))
                .toList();
    }

    @Test
    void getAllTechnologies_returnsListWithCorrectSize() throws Exception {
        Mockito.when(technologyService.getAllTechnologies(anyString())).thenReturn(techList);

        mockMvc.perform(get(TECHNOLOGY + ALL)
                        .header("Accept-Language", "es"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(techList.size()));
    }

    @Test
    void getAllTechnologies_defaultsToEs() throws Exception {
        Mockito.when(technologyService.getAllTechnologies("es")).thenReturn(techList);

        mockMvc.perform(get(TECHNOLOGY + ALL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(techList.size()));
    }

    @Test
    void getAllTechnologies_withEnLang() throws Exception {
        Mockito.when(technologyService.getAllTechnologies("en")).thenReturn(techList);

        mockMvc.perform(get(TECHNOLOGY + ALL)
                        .header("Accept-Language", "en"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(techList.size()));
    }

    @Test
    void getAllTechnologiesPaginated_returnsCorrectPageSize() throws Exception {
        List<TechnologyDto> pageContent = techList.subList(0, 10);
        Page<TechnologyDto> page = new PageImpl<>(pageContent, PageRequest.of(0, 10), techList.size());

        Mockito.when(technologyService.getAllTechnologiesPaginated(anyInt(), anyInt(), anyString(), anyString()))
                .thenReturn(page);

        mockMvc.perform(get(TECHNOLOGY)
                        .header("Accept-Language", "es"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(pageContent.size()))
                .andExpect(jsonPath("$.totalElements").value(techList.size()))
                .andExpect(jsonPath("$.totalPages").value(2));
    }

    @Test
    void getAllCategories_returnsOk() throws Exception {
        Mockito.when(technologyService.getAllCategories(anyString())).thenReturn(List.of());

        mockMvc.perform(get(TECHNOLOGY + CATEGORIES)
                        .header("Accept-Language", "es"))
                .andExpect(status().isOk());
    }
}