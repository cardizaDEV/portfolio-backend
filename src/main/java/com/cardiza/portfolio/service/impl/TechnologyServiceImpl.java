package com.cardiza.portfolio.service.impl;

import com.cardiza.portfolio.dto.TechnologyCategoryDto;
import com.cardiza.portfolio.dto.TechnologyDto;
import com.cardiza.portfolio.entity.Technology;
import com.cardiza.portfolio.mapper.GenericMapper;
import com.cardiza.portfolio.repository.TechnologyCategoryRepository;
import com.cardiza.portfolio.repository.TechnologyRepository;
import com.cardiza.portfolio.service.TechnologyService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnologyServiceImpl implements TechnologyService {

    @NonNull
    private final GenericMapper genericMapper;
    @NonNull
    private final TechnologyRepository technologyRepository;
    @NonNull
    private final TechnologyCategoryRepository technologyCategoryRepository;

    @Override
    @Cacheable(value = "technologies", key = "#lang")
    public List<TechnologyDto> getAllTechnologies(String lang) {
        return this.technologyRepository.findAll()
                .stream()
                .map(t -> this.genericMapper.technologyToDto(t, lang))
                .toList();
    }

    @Override
    @Cacheable(value = "technologies", key = "#lang + '-' + #page + '-' + #size + '-' + #sortBy")
    public Page<TechnologyDto> getAllTechnologiesPaginated(int page, int size, String sortBy, String lang) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        Page<Technology> techPage = technologyRepository.findAll(pageable);
        List<TechnologyDto> dtoList = techPage.getContent()
                .stream()
                .map(t -> this.genericMapper.technologyToDto(t, lang))
                .toList();
        return new PageImpl<>(dtoList, pageable, techPage.getTotalElements());
    }

    @Override
    @Cacheable(value = "technologyCategories", key = "#lang")
    public List<TechnologyCategoryDto> getAllCategories(String lang) {
        return this.technologyCategoryRepository.findAll()
                .stream()
                .map(c -> this.genericMapper.technologyCategoryToDto(c, lang))
                .toList();
    }
}
