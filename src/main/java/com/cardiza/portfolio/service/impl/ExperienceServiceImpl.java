package com.cardiza.portfolio.service.impl;

import com.cardiza.portfolio.dto.ExperienceCategoryDto;
import com.cardiza.portfolio.dto.ExperienceDto;
import com.cardiza.portfolio.dto.ExperienceStatusDto;
import com.cardiza.portfolio.entity.Experience;
import com.cardiza.portfolio.entity.Technology;
import com.cardiza.portfolio.mapper.GenericMapper;
import com.cardiza.portfolio.repository.ExperienceCategoryRepository;
import com.cardiza.portfolio.repository.ExperienceRepository;
import com.cardiza.portfolio.repository.ExperienceStatusRepository;
import com.cardiza.portfolio.repository.TechnologyRepository;
import com.cardiza.portfolio.service.ExperienceService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    @NonNull
    private final GenericMapper genericMapper;
    @NonNull
    private final ExperienceRepository experienceRepository;
    @NonNull
    private final ExperienceCategoryRepository experienceCategoryRepository;
    @NonNull
    private final ExperienceStatusRepository experienceStatusRepository;
    @NonNull
    private final TechnologyRepository technologyRepository;

    @Override
    @Cacheable("experiences")
    public List<ExperienceDto> getAllExperiences() {
        return this.experienceRepository.findAll()
                .stream()
                .map(exp -> {
                    Set<Technology> technologies = this.technologyRepository.findAllByExperiences_Id(exp.getId());
                    return this.genericMapper.experienceToDto(exp, technologies);
                })
                .toList();
    }

    @Override
    @Cacheable(value = "experiences", key = "#page + '-' + #size + '-' + #sortBy")
    public Page<ExperienceDto> getAllExperiencesPaginated(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        Page<Experience> experiencePage = experienceRepository.findAll(pageable);
        List<ExperienceDto> dtoList = experiencePage.getContent()
                .stream()
                .map(exp -> {
                    Set<Technology> technologies = this.technologyRepository.findAllByExperiences_Id(exp.getId());
                    return this.genericMapper.experienceToDto(exp, technologies);
                })
                .toList();
        return new PageImpl<>(dtoList, pageable, experiencePage.getTotalElements());
    }

    @Override
    @Cacheable("experienceCategories")
    public List<ExperienceCategoryDto> getAllCategories() {
        return this.experienceCategoryRepository.findAll()
                .stream()
                .map(this.genericMapper::experienceCategoryToDto)
                .toList();
    }

    @Override
    @Cacheable("experienceStatuses")
    public List<ExperienceStatusDto> getAllStatuses() {
        return this.experienceStatusRepository.findAll()
                .stream()
                .map(this.genericMapper::experienceStatusToDto)
                .toList();
    }
}