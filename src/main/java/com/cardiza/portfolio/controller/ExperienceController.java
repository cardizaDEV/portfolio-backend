package com.cardiza.portfolio.controller;

import com.cardiza.portfolio.dto.ExperienceDto;
import com.cardiza.portfolio.service.ExperienceService;
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
import static com.cardiza.portfolio.config.ControllerNamings.EXPERIENCE;

@RestController
@RequestMapping(EXPERIENCE)
@RequiredArgsConstructor
public class ExperienceController {

    @NonNull
    private final ExperienceService experienceService;

    @GetMapping(ALL)
    public List<ExperienceDto> getAllExperiences() {
        return this.experienceService.getAllExperiences();
    }

    @GetMapping
    public Page<ExperienceDto> getAllExperiencesPaginated(
            @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int size,
            @RequestParam(defaultValue = DEFAULT_SORT_BY) String sortBy
    ) {
        return this.experienceService.getAllExperiencesPaginated(page, size, sortBy);
    }
}
