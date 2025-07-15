package com.gbueno.app.dtos;

import lombok.Data;

import java.util.List;

@Data
public class QuizWithQuestionsDto {
    private Long id;
    private String title;
    private String categoryName;
    private List<QuestionDto> questions;
}
