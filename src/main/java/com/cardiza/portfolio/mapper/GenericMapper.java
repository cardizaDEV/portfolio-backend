package com.cardiza.portfolio.mapper;

import com.cardiza.portfolio.dto.*;
import com.cardiza.portfolio.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GenericMapper {

    TechnologyDto technologyToDto(Technology technology);

    TechnologyCategoryDto technologyCategoryToDto(TechnologyCategory technologyCategory);

    OrganizationDto organizationToDto(Organization organization);

    @Mapping(source = "status.name", target = "status")
    @Mapping(source = "category.name", target = "category")
    @Mapping(source = "organization", target = "organization")
    ExperienceDto experienceToDto(Experience experience);

    @Mapping(source = "experience.id", target = "experienceId")
    CommentDto commentToDto(Comment comment);
}