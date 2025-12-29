package com.education.platform.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course_labels")
@Getter
@Setter
@NoArgsConstructor
public class CourseLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "labels")
    private Set<EducationalCourse> courses = new HashSet<>();
}