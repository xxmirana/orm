package com.education.platform;

import com.education.platform.entity.EducationalCourse;
import com.education.platform.repository.EducationalCourseRepository;
import com.education.platform.repository.CourseModuleRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class LazyLoadingTest {

    @Autowired EducationalCourseRepository courseRepository;
    @Autowired CourseModuleRepository moduleRepository;
    @Autowired EntityManager entityManager;

    @Test
    void lazyCollectionAccessCausesException() {
        EducationalCourse course = new EducationalCourse();
        course.setTitle("Тестовый образовательный курс");
        course = courseRepository.save(course);

        CourseModule module = new CourseModule();
        module.setCourse(course);
        module.setTitle("Тестовый модуль");
        module.setSequenceNumber(1);
        moduleRepository.save(module);

        entityManager.flush();
        entityManager.clear();

        EducationalCourse retrievedCourse = courseRepository.findById(course.getId()).orElseThrow();
        assertThrows(LazyInitializationException.class,
                () -> retrievedCourse.getModules().size());
    }
}