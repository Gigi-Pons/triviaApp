package com.gbueno.app.repositories;

import com.gbueno.app.entities.Category;
import com.gbueno.app.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByCategory(Category category);
    List<Quiz> findByCategoryId(Long categoryId);
}
