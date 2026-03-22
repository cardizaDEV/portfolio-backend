package com.cardiza.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static com.cardiza.portfolio.config.ApplicationValues.DEFAULT_LONG_STRING_LENGTH;
import static com.cardiza.portfolio.config.EntityNamings.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = ORGANIZATION_ID, nullable = false)
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = STATUS_ID, nullable = false)
    private ExperienceStatus status;

    @ManyToOne
    @JoinColumn(name = CATEGORY_ID, nullable = false)
    private ExperienceCategory category;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column()
    private LocalDate endDate;

    @OneToMany(mappedBy = EXPERIENCE, fetch = FetchType.LAZY)
    private List<Comment> comments;

    @Column(nullable = false, length = DEFAULT_LONG_STRING_LENGTH)
    private String titleEs;

    @Column(nullable = false, length = DEFAULT_LONG_STRING_LENGTH)
    private String titleEn;

    @Column(columnDefinition = "TEXT")
    private String descriptionEs;

    @Column(columnDefinition = "TEXT")
    private String descriptionEn;

    @ManyToMany
    @JoinTable(
            name = "experience_technology",
            joinColumns = @JoinColumn(name = EXPERIENCE_ID),
            inverseJoinColumns = @JoinColumn(name = TECHNOLOGY_ID)
    )
    private Set<Technology> technologies;
}