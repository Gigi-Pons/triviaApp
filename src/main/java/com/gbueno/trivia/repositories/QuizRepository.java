package com.gbueno.trivia.repositories;

import com.gbueno.trivia.entities.Category;
import com.gbueno.trivia.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuizRepository extends JpaRepository<Quiz, UUID> {
    List<Quiz> findByCategory(Category category);
}
