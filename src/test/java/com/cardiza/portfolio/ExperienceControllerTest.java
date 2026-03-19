package com.cardiza.portfolio;

import com.cardiza.portfolio.controller.ExperienceController;
import com.cardiza.portfolio.dto.ExperienceDto;
import com.cardiza.portfolio.dto.OrganizationDto;
import com.cardiza.portfolio.dto.TechnologyCategoryDto;
import com.cardiza.portfolio.dto.TechnologyDto;
import com.cardiza.portfolio.service.ExperienceService;
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

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static com.cardiza.portfolio.config.ControllerNamings.ALL;
import static com.cardiza.portfolio.config.ControllerNamings.EXPERIENCE;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExperienceController.class)
class ExperienceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExperienceService experienceService;

    private List<ExperienceDto> experienceList;

    @BeforeEach
    void setUp() {
        experienceList = IntStream.rangeClosed(1, 15)
                .mapToObj(i -> new ExperienceDto(
                        i,
                        "Experience " + i,
                        new OrganizationDto(i % 5 + 1, "Organization " + (i % 5 + 1), null),
                        i % 3 == 0 ? "active" : "inactive",
                        i % 4 == 0 ? "work" : "education",
                        "Description for experience " + i,
                        LocalDate.now().minusMonths(i),
                        LocalDate.now().minusMonths(i - 1),
                        Set.of(
                                new TechnologyDto(i, "Technology " + i, null, Set.of(
                                        new TechnologyCategoryDto(i % 3 + 1, "Category " + (i % 3 + 1), "#FEF0DC", "#7A3E00", "#F9C47A")
                                ))
                        )
                ))
                .toList();
    }

    @Test
    void getAllExperiences() throws Exception {
        Mockito.when(experienceService.getAllExperiences()).thenReturn(experienceList);

        mockMvc.perform(get(EXPERIENCE + ALL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(experienceList.size()));
    }

    @Test
    void getAllExperiencesPaginated() throws Exception {
        List<ExperienceDto> pageContent = experienceList.subList(0, 10);
        Page<ExperienceDto> page = new PageImpl<>(pageContent, PageRequest.of(0, 10), experienceList.size());

        Mockito.when(experienceService.getAllExperiencesPaginated(anyInt(), anyInt(), anyString()))
                .thenReturn(page);

        mockMvc.perform(get(EXPERIENCE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(pageContent.size()));
    }
}