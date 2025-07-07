package com.gbueno.app.services;

import com.gbueno.app.dtos.OptionDto;
import com.gbueno.app.dtos.QuestionDto;
import com.gbueno.app.entities.Quiz;
import com.gbueno.app.repositories.OptionRepository;
import com.gbueno.app.repositories.QuestionRepository;
import com.gbueno.app.repositories.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;

    public List<QuestionDto> getQuizQuestions(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        return questionRepository.findByQuiz(quiz).stream().map(question -> {
            QuestionDto questionDto = new QuestionDto();
            questionDto.setId(question.getId());
            questionDto.setText(question.getText());

            List<OptionDto> optionDtos = optionRepository.findByQuestion(question).stream().map(option -> {
                OptionDto o = new OptionDto();
                o.setLabel(option.getLabel());
                o.setText((option.getText()));
                return o;
            }).toList();

            questionDto.setOptions(optionDtos);
            return questionDto;
        }).toList();
    }
}
