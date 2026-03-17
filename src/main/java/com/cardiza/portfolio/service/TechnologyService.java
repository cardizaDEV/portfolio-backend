package com.cardiza.portfolio.service;

import com.cardiza.portfolio.dto.TechnologyDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TechnologyService {
    List<TechnologyDto> getAllTechnologies();

    Page<TechnologyDto> getAllTechnologiesPaginated(int page, int size, String sortBy);
}
