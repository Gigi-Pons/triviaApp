package com.gbueno.app.controllers;

import com.gbueno.app.dtos.QuestionDto;
import com.gbueno.app.dtos.QuizDto;
import com.gbueno.app.services.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @GetMapping("/quizzes/{id}/questions")
    public List<QuestionDto> getQuizQuestions(@PathVariable Long id) {
        return quizService.getQuizQuestions(id);
    }

    public List<QuizDto> getQuizzes() {
        return null;
    }

}
