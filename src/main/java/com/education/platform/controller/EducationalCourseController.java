package com.education.platform.controller;

import com.education.platform.entity.EducationalCourse;
import com.education.platform.service.EducationalCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class EducationalCourseController {

    private final EducationalCourseService courseService;

    @PostMapping
    public EducationalCourse createCourse(@RequestBody EducationalCourse course) {
        return courseService.createCourse(course);
    }

    @GetMapping("/{id}/full")
    public EducationalCourse getFullCourseStructure(@PathVariable Long id) {
        return courseService.getCourseWithStructure(id);
    }
}