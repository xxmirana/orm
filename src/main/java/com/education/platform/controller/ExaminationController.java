package com.education.platform.repository;

import com.education.platform.entity.CourseExamination;
import com.education.platform.entity.ExaminationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExaminationResultRepository extends JpaRepository<ExaminationResult, Long> {
    List<ExaminationResult> findByQuiz(CourseExamination quiz);
    List<ExaminationResult> findByStudentId(Long studentId);
}