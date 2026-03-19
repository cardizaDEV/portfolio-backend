package com.cardiza.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnologyCategoryDto {

    private Integer id;
    private String name;
    private String colorBg;
    private String colorText;
    private String colorBorder;
}