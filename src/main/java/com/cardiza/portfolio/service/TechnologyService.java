package com.cardiza.portfolio.service;

import com.cardiza.portfolio.dto.TechnologyCategoryDto;
import com.cardiza.portfolio.dto.TechnologyDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TechnologyService {
    List<TechnologyDto> getAllTechnologies(String lang);

    Page<TechnologyDto> getAllTechnologiesPaginated(int page, int size, String sortBy, String lang);

    List<TechnologyCategoryDto> getAllCategories(String lang);
}