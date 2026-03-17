package com.cardiza.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.cardiza.portfolio.config.ApplicationValues.DEFAULT_STRING_LENGTH;
import static com.cardiza.portfolio.config.EntityNamings.EXPERIENCE_STATUS;

@Entity
@Table(name = EXPERIENCE_STATUS)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = DEFAULT_STRING_LENGTH)
    private String name;

    @OneToMany(mappedBy = EXPERIENCE_STATUS)
    private List<Experience> experiences;
}