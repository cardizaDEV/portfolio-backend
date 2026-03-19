package com.cardiza.portfolio.service;

import com.cardiza.portfolio.dto.ExperienceCategoryDto;
import com.cardiza.portfolio.dto.ExperienceDto;
import com.cardiza.portfolio.dto.ExperienceStatusDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ExperienceService {
    List<ExperienceDto> getAllExperiences();

    Page<ExperienceDto> getAllExperiencesPaginated(int page, int size, String sortBy);

    List<ExperienceCategoryDto> getAllCategories();

    List<ExperienceStatusDto> getAllStatuses();
}
