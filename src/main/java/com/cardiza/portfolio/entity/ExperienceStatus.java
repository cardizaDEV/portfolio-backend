package com.cardiza.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.cardiza.portfolio.config.ApplicationValues.DEFAULT_STRING_LENGTH;
import static com.cardiza.portfolio.config.EntityNamings.EXPERIENCE_STATUS;
import static com.cardiza.portfolio.config.EntityNamings.STATUS;

@Entity
@Table(name = EXPERIENCE_STATUS)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceStatus {

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

    @OneToMany(mappedBy = STATUS, fetch = FetchType.LAZY)
    private List<Experience> experiences;
}