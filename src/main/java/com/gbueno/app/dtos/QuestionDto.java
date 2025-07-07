package com.gbueno.app.dtos;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {
    private Long id;
    private String text;
    private List<OptionDto> options;
}
