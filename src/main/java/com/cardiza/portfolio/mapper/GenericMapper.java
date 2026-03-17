package com.cardiza.portfolio.mapper;

import com.cardiza.portfolio.dto.CommentDto;
import com.cardiza.portfolio.dto.ExperienceDto;
import com.cardiza.portfolio.dto.OrganizationDto;
import com.cardiza.portfolio.dto.TechnologyDto;
import com.cardiza.portfolio.entity.Comment;
import com.cardiza.portfolio.entity.Experience;
import com.cardiza.portfolio.entity.Organization;
import com.cardiza.portfolio.entity.Technology;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenericMapper {

    TechnologyDto technologyToDto(Technology technology);

    OrganizationDto organizationToDto(Organization organization);

    ExperienceDto experienceToDto(Experience experience);

    CommentDto commentToDto(Comment comment);
}
