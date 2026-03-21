package com.cardiza.portfolio.controller;

import com.cardiza.portfolio.dto.ExperienceCategoryDto;
import com.cardiza.portfolio.dto.ExperienceDto;
import com.cardiza.portfolio.dto.ExperienceStatusDto;
import com.cardiza.portfolio.service.ExperienceService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cardiza.portfolio.config.ApplicationValues.*;
import static com.cardiza.portfolio.config.ControllerNamings.*;

@RestController
@RequestMapping(EXPERIENCE)
@RequiredArgsConstructor
public class ExperienceController {

    @NonNull
    private final ExperienceService experienceService;

    @GetMapping(ALL)
    public List<ExperienceDto> getAllExperiences(@RequestHeader(value = "Accept-Language", defaultValue = "es") String lang) {
        return this.experienceService.getAllExperiences(lang);
    }

    @GetMapping
    public Page<ExperienceDto> getAllExperiencesPaginated(
            @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int size,
            @RequestParam(defaultValue = DEFAULT_SORT_BY) String sortBy,
            @RequestHeader(value = "Accept-Language", defaultValue = "es") String lang
    ) {
        return this.experienceService.getAllExperiencesPaginated(page, size, sortBy, lang);
    }

    @GetMapping(CATEGORIES)
    public List<ExperienceCategoryDto> getAllCategories(@RequestHeader(value = "Accept-Language", defaultValue = "es") String lang) {
        return this.experienceService.getAllCategories(lang);
    }

    @GetMapping(STATUSES)
    public List<ExperienceStatusDto> getAllStatuses(@RequestHeader(value = "Accept-Language", defaultValue = "es") String lang) {
        return this.experienceService.getAllStatuses(lang);
    }
}