package com.cardiza.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDto {

    private long id;
    private String title;
    private long organizationId;
    private long statusId;
    private long categoryId;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
