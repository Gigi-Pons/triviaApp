package com.gbueno.trivia.controllers;

import com.gbueno.trivia.entities.Category;
import com.gbueno.trivia.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
//@RequiredArgsConstructor
public class TestController {

    private final CategoryRepository categoryRepository;

    public TestController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}

//@RequestMapping("/test")
//@RestController
//@RequiredArgsConstructor
//public class TestController {
//    private final CategoryRepository categoryRepository;
//
//    @GetMapping
//    public List<Category> getAllCategories() {
//        return categoryRepository.findAll();
//    }
//}
