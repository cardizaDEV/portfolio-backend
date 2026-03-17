package com.cardiza.portfolio.service.impl;

import com.cardiza.portfolio.dto.ExperienceDto;
import com.cardiza.portfolio.entity.Experience;
import com.cardiza.portfolio.mapper.GenericMapper;
import com.cardiza.portfolio.repository.ExperienceRepository;
import com.cardiza.portfolio.service.ExperienceService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    @NonNull
    private final GenericMapper genericMapper;
    @NonNull
    private final ExperienceRepository experienceRepository;

    @Override
    @Cacheable("experiences")
    public List<ExperienceDto> getAllExperiences() {
        return this.experienceRepository.findAll()
                .stream()
                .map(this.genericMapper::experienceToDto)
                .toList();
    }

    @Override
    public Page<ExperienceDto> getAllExperiencesPaginated(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        Page<Experience> experiencePage = experienceRepository.findAll(pageable);
        List<ExperienceDto> dtoList = experiencePage.getContent()
                .stream()
                .map(genericMapper::experienceToDto)
                .toList();
        return new PageImpl<>(dtoList, pageable, experiencePage.getTotalElements());
    }
}
