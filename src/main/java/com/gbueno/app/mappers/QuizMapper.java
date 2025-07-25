package com.gbueno.app.mappers;

import com.gbueno.app.dtos.CategoryDto;
import com.gbueno.app.dtos.QuizDto;
import com.gbueno.app.entities.Category;
import com.gbueno.app.entities.Quiz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuizMapper {
    //converting a category into a categoryDTO
    CategoryDto toCategoryDto(Category category);
    @Mapping(target = "category", expression = "java(quiz.getCategory().getName())")
    @Mapping(target = "questionCount", expression = "java(quiz.getQuestions().size())")
    QuizDto toDto(Quiz quiz);
}
