package com.cardiza.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDto {

    private Integer id;
    private String title;
    private OrganizationDto organization;
    private ExperienceStatusDto status;
    private ExperienceCategoryDto category;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<TechnologyDto> technologies;
}