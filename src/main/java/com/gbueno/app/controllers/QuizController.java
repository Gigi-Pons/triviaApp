package com.gbueno.app.controllers;

import com.gbueno.app.dtos.CategoryDto;
import com.gbueno.app.dtos.QuestionDto;
import com.gbueno.app.dtos.QuizDto;
import com.gbueno.app.dtos.QuizWithQuestionsDto;
import com.gbueno.app.entities.Quiz;
import com.gbueno.app.services.QuizService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
@AllArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @GetMapping
    public ResponseEntity<List<QuizDto>> getAllQuizzes() {

        List<QuizDto> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDto> getQuizById(
            @PathVariable Long id
    ) {
        QuizDto quiz = quizService.getQuizById(id);
        return ResponseEntity.ok(quiz);
    }




    @GetMapping("/categories")
    public List<CategoryDto> getCategories() {
        return quizService.getAllCategories();
    }



    @GetMapping("/quizzes/random")
    public ResponseEntity<QuizWithQuestionsDto> getRandomQuiz(
            @RequestParam Long categoryId // use RequestParam when the value is used to filter, sort, or modify how you retrieve a resource
    ) {
        return quizService.getRandomQuizWithQuestions(categoryId);
    }


}
