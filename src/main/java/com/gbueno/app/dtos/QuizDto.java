package com.gbueno.app.dtos;

import lombok.Data;

import java.util.List;

@Data
public class QuizDto {
    private Long id;
    private String title;
    private String category;
    private List<QuestionDto> questions;
}
