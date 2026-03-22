package com.cardiza.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import static com.cardiza.portfolio.config.ApplicationValues.DEFAULT_LONG_STRING_LENGTH;
import static com.cardiza.portfolio.config.EntityNamings.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = DEFAULT_LONG_STRING_LENGTH)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String url;

    @ManyToMany(mappedBy = TECHNOLOGIES, fetch = FetchType.LAZY)
    private Set<Experience> experiences;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "technology_technology_category",
            joinColumns = @JoinColumn(name = TECHNOLOGY_ID),
            inverseJoinColumns = @JoinColumn(name = CATEGORY_ID)
    )
    private Set<TechnologyCategory> categories;
}