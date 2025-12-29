package com.education.platform.repository;

import com.education.platform.entity.ExaminationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationResultRepository extends JpaRepository<ExaminationResult, Long> {
}