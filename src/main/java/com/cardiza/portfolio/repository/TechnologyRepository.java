package com.cardiza.portfolio.repository;

import com.cardiza.portfolio.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}
