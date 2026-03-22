package com.cardiza.portfolio.service.impl;

import com.cardiza.portfolio.dto.OrganizationDto;
import com.cardiza.portfolio.entity.Organization;
import com.cardiza.portfolio.mapper.GenericMapper;
import com.cardiza.portfolio.repository.OrganizationRepository;
import com.cardiza.portfolio.service.OrganizationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    @NonNull
    private final GenericMapper genericMapper;
    @NonNull
    private final OrganizationRepository organizationRepository;

    @Override
    @Cacheable("organizations")
    public List<OrganizationDto> getAllOrganizations() {
        return this.organizationRepository.findAll()
                .stream()
                .map(this.genericMapper::organizationToDto)
                .toList();
    }

    @Override
    @Cacheable(value = "organizations", key = "#page + '-' + #size + '-' + #sortBy")
    public Page<OrganizationDto> getAllOrganizationsPaginated(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        Page<Organization> orgPage = organizationRepository.findAll(pageable);
        List<OrganizationDto> dtoList = orgPage.getContent()
                .stream()
                .map(genericMapper::organizationToDto)
                .toList();
        return new PageImpl<>(dtoList, pageable, orgPage.getTotalElements());
    }
}
