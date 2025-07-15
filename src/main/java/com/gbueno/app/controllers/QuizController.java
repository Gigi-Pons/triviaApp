package com.gbueno.app.controllers;

import com.gbueno.app.dtos.CategoryDto;
import com.gbueno.app.dtos.QuestionDto;
import com.gbueno.app.dtos.QuizDto;
import com.gbueno.app.services.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/quizzes")
    public List<QuizDto> getQuizzes() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/categories")
    public List<CategoryDto> getCategories() {
        return quizService.getAllCategories();
    }

    @GetMapping("/quizzes/random")
    public QuizDto getRandomQuiz(
            @RequestParam Long categoryId // use RequestParam when the value is used to filter, sort, or modify how you retrieve a resource
    ) {
        return quizService.getRandomQuizByCategoryId(categoryId);
    }


}
