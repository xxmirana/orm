package com.education.platform.service;

import com.education.platform.entity.EducationalCourse;
import com.education.platform.repository.EducationalCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EducationalCourseService {

    private final EducationalCourseRepository courseRepository;

    @Transactional
    public EducationalCourse createCourse(EducationalCourse course) {
        return courseRepository.save(course);
    }

    @Transactional(readOnly = true)
    public EducationalCourse getCourseWithStructure(Long id) {
        return courseRepository.findWithStructureById(id)
                .orElseThrow(() -> new RuntimeException("Курс не найден: " + id));
    }
}