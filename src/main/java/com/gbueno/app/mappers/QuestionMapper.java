package com.gbueno.app.mappers;

import com.gbueno.app.dtos.OptionDto;
import com.gbueno.app.dtos.QuestionDto;
import com.gbueno.app.entities.Option;
import com.gbueno.app.entities.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionDto toQuestionDto(Question question);
    List<OptionDto> toOptionDtoList(List<Option> options);
}
