package com.cardiza.portfolio.repository;

import com.cardiza.portfolio.entity.TechnologyCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyCategoryRepository extends JpaRepository<TechnologyCategory, Integer> {
}
