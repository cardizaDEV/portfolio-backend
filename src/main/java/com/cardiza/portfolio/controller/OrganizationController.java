package com.cardiza.portfolio.controller;

import com.cardiza.portfolio.dto.OrganizationDto;
import com.cardiza.portfolio.service.OrganizationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.cardiza.portfolio.config.ApplicationValues.*;
import static com.cardiza.portfolio.config.ControllerNamings.ALL;
import static com.cardiza.portfolio.config.ControllerNamings.ORGANIZATION;

@RestController
@RequestMapping(ORGANIZATION)
@RequiredArgsConstructor
public class OrganizationController {

    @NonNull
    private final OrganizationService organizationService;

    @GetMapping(ALL)
    public List<OrganizationDto> getAllOrganizations() {
        return this.organizationService.getAllOrganizations();
    }

    @GetMapping
    public Page<OrganizationDto> getAllOrganizationsPaginated(
            @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int size,
            @RequestParam(defaultValue = DEFAULT_SORT_BY) String sortBy
    ) {
        return this.organizationService.getAllOrganizationsPaginated(page, size, sortBy);
    }
}
