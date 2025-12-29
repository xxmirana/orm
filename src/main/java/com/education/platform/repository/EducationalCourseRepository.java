package com.education.platform.repository;

import com.education.platform.entity.EducationalCourse;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EducationalCourseRepository extends JpaRepository<EducationalCourse, Long> {

    @EntityGraph(attributePaths = {"modules", "modules.units", "modules.examination"})
    Optional<EducationalCourse> findWithStructureById(Long id);
}