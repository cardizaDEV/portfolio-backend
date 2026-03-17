package com.cardiza.portfolio.repository;

import com.cardiza.portfolio.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
