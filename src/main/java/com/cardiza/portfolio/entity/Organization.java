package com.cardiza.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.cardiza.portfolio.config.ApplicationValues.DEFAULT_LONG_STRING_LENGTH;
import static com.cardiza.portfolio.config.EntityNamings.ORGANIZATION;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = DEFAULT_LONG_STRING_LENGTH)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String icon_url;

    @OneToMany(mappedBy = ORGANIZATION)
    private List<Experience> experiences;
}