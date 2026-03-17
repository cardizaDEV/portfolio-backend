package com.cardiza.portfolio.service;

import com.cardiza.portfolio.dto.OrganizationDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrganizationService {
    List<OrganizationDto> getAllOrganizations();

    Page<OrganizationDto> getAllOrganizationsPaginated(int page, int size, String sortBy);
}
