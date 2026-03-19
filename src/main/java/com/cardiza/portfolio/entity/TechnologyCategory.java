package com.cardiza.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.cardiza.portfolio.config.ApplicationValues.DEFAULT_LONG_STRING_LENGTH;
import static com.cardiza.portfolio.config.EntityNamings.*;

@Entity
@Table(name = TECHNOLOGY_CATEGORY)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnologyCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = DEFAULT_LONG_STRING_LENGTH)
    private String name;

    @Column(name = COLOR_BG, nullable = false, length = 7)
    private String colorBg;

    @Column(name = COLOR_TEXT, nullable = false, length = 7)
    private String colorText;

    @Column(name = COLOR_BORDER, nullable = false, length = 7)
    private String colorBorder;
}