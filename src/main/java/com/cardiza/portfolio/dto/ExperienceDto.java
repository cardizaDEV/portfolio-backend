package com.cardiza.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDto {

    private Integer id;
    private String title;
    private Integer organizationId;
    private Integer statusId;
    private Integer categoryId;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
