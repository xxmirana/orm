package com.education.platform.dto;

import lombok.Data;
import java.util.Map;

@Data
public class QuizResponseRequest {
    private Map<Long, Long> answers; // questionId -> optionId
    private Long studentId;
}