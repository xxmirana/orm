package com.education.platform.repository;

import com.education.platform.entity.LearningTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningTaskRepository extends JpaRepository<LearningTask, Long> {
}