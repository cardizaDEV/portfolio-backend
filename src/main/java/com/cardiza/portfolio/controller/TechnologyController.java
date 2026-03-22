package com.cardiza.portfolio.controller;

import com.cardiza.portfolio.dto.TechnologyCategoryDto;
import com.cardiza.portfolio.dto.TechnologyDto;
import com.cardiza.portfolio.service.TechnologyService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cardiza.portfolio.config.ApplicationValues.*;
import static com.cardiza.portfolio.config.ControllerNamings.*;

@RestController
@RequestMapping(TECHNOLOGY)
@RequiredArgsConstructor
public class TechnologyController {

    @NonNull
    private final TechnologyService technologyService;

    @GetMapping(ALL)
    public List<TechnologyDto> getAllTechnologies(
            @RequestHeader(value = "Accept-Language", defaultValue = "es") String lang) {
        return this.technologyService.getAllTechnologies(lang);
    }

    @GetMapping
    public Page<TechnologyDto> getAllTechnologiesPaginated(
            @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int size,
            @RequestParam(defaultValue = DEFAULT_SORT_BY) String sortBy,
            @RequestHeader(value = "Accept-Language", defaultValue = "es") String lang) {
        return this.technologyService.getAllTechnologiesPaginated(page, size, sortBy, lang);
    }

    @GetMapping(CATEGORIES)
    public List<TechnologyCategoryDto> getAllCategories(
            @RequestHeader(value = "Accept-Language", defaultValue = "es") String lang) {
        return this.technologyService.getAllCategories(lang);
    }
}
