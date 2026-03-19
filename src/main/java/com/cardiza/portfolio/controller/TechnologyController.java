package com.cardiza.portfolio.controller;

import com.cardiza.portfolio.dto.TechnologyCategoryDto;
import com.cardiza.portfolio.dto.TechnologyDto;
import com.cardiza.portfolio.service.TechnologyService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public List<TechnologyDto> getAllTechnologies() {
        return this.technologyService.getAllTechnologies();
    }

    @GetMapping
    public Page<TechnologyDto> getAllTechnologiesPaginated(
            @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int size,
            @RequestParam(defaultValue = DEFAULT_SORT_BY) String sortBy
    ) {
        return this.technologyService.getAllTechnologiesPaginated(page, size, sortBy);
    }

    @GetMapping(CATEGORIES)
    public List<TechnologyCategoryDto> getAllCategories() {
        return this.technologyService.getAllCategories();
    }
}
