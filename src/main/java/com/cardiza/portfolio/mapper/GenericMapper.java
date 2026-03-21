package com.cardiza.portfolio.mapper;

import com.cardiza.portfolio.dto.*;
import com.cardiza.portfolio.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface GenericMapper {

    TechnologyDto technologyToDto(Technology technology);

    @Mapping(target = "name", ignore = true)
    TechnologyCategoryDto technologyCategoryToDto(TechnologyCategory technologyCategory);

    @Mapping(target = "name", ignore = true)
    ExperienceStatusDto experienceStatusToDto(ExperienceStatus experienceStatus);

    @Mapping(target = "name", ignore = true)
    ExperienceCategoryDto experienceCategoryToDto(ExperienceCategory experienceCategory);

    OrganizationDto organizationToDto(Organization organization);

    @Mapping(source = "experience.organization", target = "organization")
    @Mapping(source = "experience.status", target = "status")
    @Mapping(source = "experience.category", target = "category")
    @Mapping(source = "experience.id", target = "id")
    @Mapping(target = "title", ignore = true)
    @Mapping(target = "description", ignore = true)
    @Mapping(source = "experience.startDate", target = "startDate")
    @Mapping(source = "experience.endDate", target = "endDate")
    @Mapping(source = "technologies", target = "technologies")
    ExperienceDto experienceToDto(Experience experience, Set<Technology> technologies);

    default ExperienceDto experienceToDto(Experience experience, Set<Technology> technologies, String lang) {
        ExperienceDto dto = experienceToDto(experience, technologies);
        dto.setTitle("es".equals(lang) ? experience.getTitleEs() : experience.getTitleEn());
        dto.setDescription("es".equals(lang) ? experience.getDescriptionEs() : experience.getDescriptionEn());
        dto.getStatus().setName("es".equals(lang) ? experience.getStatus().getNameEs() : experience.getStatus().getNameEn());
        dto.getCategory().setName("es".equals(lang) ? experience.getCategory().getNameEs() : experience.getCategory().getNameEn());
        dto.setTechnologies(technologies.stream()
                .map(t -> technologyToDto(t, lang))
                .collect(java.util.stream.Collectors.toSet()));
        return dto;
    }

    default TechnologyDto technologyToDto(Technology technology, String lang) {
        TechnologyDto dto = technologyToDto(technology);
        dto.setCategories(technology.getCategories().stream()
                .map(c -> technologyCategoryToDto(c, lang))
                .collect(java.util.stream.Collectors.toSet()));
        return dto;
    }

    default TechnologyCategoryDto technologyCategoryToDto(TechnologyCategory category, String lang) {
        TechnologyCategoryDto dto = technologyCategoryToDto(category);
        dto.setName("es".equals(lang) ? category.getNameEs() : category.getNameEn());
        return dto;
    }

    default ExperienceStatusDto experienceStatusToDto(ExperienceStatus status, String lang) {
        ExperienceStatusDto dto = experienceStatusToDto(status);
        dto.setName("es".equals(lang) ? status.getNameEs() : status.getNameEn());
        return dto;
    }

    default ExperienceCategoryDto experienceCategoryToDto(ExperienceCategory category, String lang) {
        ExperienceCategoryDto dto = experienceCategoryToDto(category);
        dto.setName("es".equals(lang) ? category.getNameEs() : category.getNameEn());
        return dto;
    }

    @Mapping(source = "experience.id", target = "experienceId")
    CommentDto commentToDto(Comment comment);
}