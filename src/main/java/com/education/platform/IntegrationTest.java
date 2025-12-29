package com.education.platform;

import com.education.platform.entity.*;
import com.education.platform.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class IntegrationTest {

    @Autowired private PlatformUserRepository userRepository;
    @Autowired private EducationalCourseRepository courseRepository;
    @Autowired private CourseModuleRepository moduleRepository;
    @Autowired private LearningUnitRepository unitRepository;
    @Autowired private LearningTaskRepository taskRepository;
    @Autowired private TaskSubmissionRepository submissionRepository;

    @Test
    void completeEducationalFlowTest() {
        PlatformUser instructor = new PlatformUser();
        instructor.setEmail("instructor@platform.edu");
        instructor.setPassword("instructor123");
        instructor.setFullName("Доктор Наук");
        instructor.setRole(UserRole.INSTRUCTOR);

        PlatformUser learner = new PlatformUser();
        learner.setEmail("learner@platform.edu");
        learner.setPassword("learner123");
        learner.setFullName("Студент Учеников");
        learner.setRole(UserRole.STUDENT);

        userRepository.saveAll(java.util.List.of(instructor, learner));

        EducationalCourse course = new EducationalCourse();
        course.setTitle("Продвинутое программирование на Java");
        course.setInstructor(instructor);
        course = courseRepository.save(course);

        CourseModule module = new CourseModule();
        module.setCourse(course);
        module.setTitle("Введение в многопоточность");
        module.setSequenceNumber(1);
        moduleRepository.save(module);

        LearningUnit unit = new LearningUnit();
        unit.setModule(module);
        unit.setTitle("Основные концепции потоков");
        unitRepository.save(unit);

        LearningTask assignment = new LearningTask();
        assignment.setLesson(unit);
        assignment.setTitle("Практическая работа №1");
        assignment.setDescription("Реализуйте многопоточное приложение");
        taskRepository.save(assignment);

        TaskSubmission solution = new TaskSubmission();
        solution.setStudent(learner);
        solution.setTask(assignment);
        solution.setContent("Мое решение задачи");
        submissionRepository.save(solution);

        assertEquals(1, submissionRepository.findAll().size());
    }
}