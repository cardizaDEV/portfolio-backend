package com.cardiza.portfolio.mapper;

import com.cardiza.portfolio.dto.*;
import com.cardiza.portfolio.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GenericMapper {

    TechnologyDto technologyToDto(Technology technology);

    TechnologyCategoryDto technologyCategoryToDto(TechnologyCategory technologyCategory);

    ExperienceStatusDto experienceStatusToDto(ExperienceStatus experienceStatus);

    ExperienceCategoryDto experienceCategoryToDto(ExperienceCategory experienceCategory);

    @Mapping(source = "logoUrl", target = "logoUrl")
    OrganizationDto organizationToDto(Organization organization);

    @Mapping(source = "organization", target = "organization")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "category", target = "category")
    ExperienceDto experienceToDto(Experience experience);

    @Mapping(source = "experience.id", target = "experienceId")
    CommentDto commentToDto(Comment comment);
}