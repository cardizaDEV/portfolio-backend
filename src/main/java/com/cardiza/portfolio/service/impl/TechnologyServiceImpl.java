package com.cardiza.portfolio.service.impl;

import com.cardiza.portfolio.dto.TechnologyDto;
import com.cardiza.portfolio.entity.Technology;
import com.cardiza.portfolio.mapper.GenericMapper;
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

    @Override
    @Cacheable("technologies")
    public List<TechnologyDto> getAllTechnologies() {
        return this.technologyRepository.findAll()
                .stream()
                .map(this.genericMapper::technologyToDto)
                .toList();
    }

    @Override
    public Page<TechnologyDto> getAllTechnologiesPaginated(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        Page<Technology> techPage = technologyRepository.findAll(pageable);
        List<TechnologyDto> dtoList = techPage.getContent()
                .stream()
                .map(genericMapper::technologyToDto)
                .toList();
        return new PageImpl<>(dtoList, pageable, techPage.getTotalElements());
    }
}
