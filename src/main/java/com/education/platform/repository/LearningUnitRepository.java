package com.education.platform.repository;

import com.education.platform.entity.LearningUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningUnitRepository extends JpaRepository<LearningUnit, Long> {
}