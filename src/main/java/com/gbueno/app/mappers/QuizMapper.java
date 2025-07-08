package com.gbueno.app.mappers;

import com.gbueno.app.dtos.CategoryDto;
import com.gbueno.app.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizMapper {
    //converting a category into a categoryDTO
    CategoryDto toCategoryDto(Category category);
}
