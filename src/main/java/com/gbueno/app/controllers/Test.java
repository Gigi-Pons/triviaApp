package com.gbueno.app.controllers;

import com.gbueno.app.entities.Category;
import com.gbueno.app.entities.Quiz;
import com.gbueno.app.entities.TestLombok;
import com.gbueno.app.repositories.CategoryRepository;
import com.gbueno.app.repositories.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/test")
public class Test {
    private final CategoryRepository categoryRepository;
    private final QuizRepository quizRepository;

    @GetMapping("/lombok")
    public String testLombok() {
        TestLombok test = new TestLombok();
        test.setMessage("Cheeto");
        test.setAge(25);

        return "Name: " + test.getMessage() + ", Age: " + test.getAge();
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/quizzes")
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }
}
