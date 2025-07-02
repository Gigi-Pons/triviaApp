package com.gbueno.trivia.controllers;

import com.gbueno.trivia.dtos.CategoryDto;
import com.gbueno.trivia.entities.Category;
import com.gbueno.trivia.entities.TestLombok;
import com.gbueno.trivia.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
        List<Category> categories = categoryRepository.findAll();

        for (Category c : categories) {
            System.out.println("Category ID: " + c.getId());
            System.out.println("Category Name: " + c.getName());
        }

        TestLombok test = new TestLombok();
        test.setMessage("Hello");
        System.out.println(test.getMessage());

        return categories;
    }

}

