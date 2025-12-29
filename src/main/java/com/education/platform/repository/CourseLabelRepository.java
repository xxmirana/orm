package com.education.platform.repository;

import com.education.platform.entity.CourseLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseLabelRepository extends JpaRepository<CourseLabel, Long> {
}