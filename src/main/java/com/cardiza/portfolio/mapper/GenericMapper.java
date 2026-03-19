package com.cardiza.portfolio.mapper;

import com.cardiza.portfolio.dto.*;
import com.cardiza.portfolio.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface GenericMapper {

    TechnologyDto technologyToDto(Technology technology);

    TechnologyCategoryDto technologyCategoryToDto(TechnologyCategory technologyCategory);

    ExperienceStatusDto experienceStatusToDto(ExperienceStatus experienceStatus);

    ExperienceCategoryDto experienceCategoryToDto(ExperienceCategory experienceCategory);

    OrganizationDto organizationToDto(Organization organization);

    @Mapping(source = "experience.organization", target = "organization")
    @Mapping(source = "experience.status", target = "status")
    @Mapping(source = "experience.category", target = "category")
    @Mapping(source = "experience.id", target = "id")
    @Mapping(source = "experience.title", target = "title")
    @Mapping(source = "experience.description", target = "description")
    @Mapping(source = "experience.startDate", target = "startDate")
    @Mapping(source = "experience.endDate", target = "endDate")
    @Mapping(source = "technologies", target = "technologies")
    ExperienceDto experienceToDto(Experience experience, Set<Technology> technologies);

    @Mapping(source = "experience.id", target = "experienceId")
    CommentDto commentToDto(Comment comment);
}