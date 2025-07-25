package com.gbueno.app.dtos;

import lombok.Data;

@Data
public class QuizDto {
    private Long id;
    private String title;
    private String category;
    private int questionCount;
}
