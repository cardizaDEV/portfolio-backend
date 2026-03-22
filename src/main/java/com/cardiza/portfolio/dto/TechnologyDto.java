package com.cardiza.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnologyDto {

    private Integer id;
    private String name;
    private String url;
    private Set<TechnologyCategoryDto> categories;
}