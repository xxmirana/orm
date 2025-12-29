package com.education.platform.repository;

import com.education.platform.entity.CourseExamination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseExaminationRepository extends JpaRepository<CourseExamination, Long> {
}