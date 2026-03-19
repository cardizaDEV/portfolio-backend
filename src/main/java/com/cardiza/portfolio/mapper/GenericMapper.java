package com.cardiza.portfolio.mapper;

import com.cardiza.portfolio.dto.*;
import com.cardiza.portfolio.entity.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenericMapper {

    TechnologyDto technologyToDto(Technology technology);

    TechnologyCategoryDto technologyCategoryToDto(TechnologyCategory technologyCategory);

    OrganizationDto organizationToDto(Organization organization);

    ExperienceDto experienceToDto(Experience experience);

    CommentDto commentToDto(Comment comment);
}
