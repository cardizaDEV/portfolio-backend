package com.cardiza.portfolio.repository;

import com.cardiza.portfolio.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {

    Set<Technology> findAllByExperiences_Id(Integer experienceId);
}
