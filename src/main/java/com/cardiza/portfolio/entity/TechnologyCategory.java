package com.cardiza.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.cardiza.portfolio.config.ApplicationValues.DEFAULT_STRING_LENGTH;
import static com.cardiza.portfolio.config.EntityNamings.TECHNOLOGY_CATEGORY;

@Entity
@Table(name = TECHNOLOGY_CATEGORY)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnologyCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = DEFAULT_STRING_LENGTH)
    private String nameEs;

    @Column(nullable = false, length = DEFAULT_STRING_LENGTH)
    private String nameEn;

    @Column(nullable = false, length = 7)
    private String colorBg;

    @Column(nullable = false, length = 7)
    private String colorText;

    @Column(nullable = false, length = 7)
    private String colorBorder;
}