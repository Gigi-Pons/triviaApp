package com.gbueno.app.repositories;

import com.gbueno.app.entities.Category;
import com.gbueno.app.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    @Query(value = "SELECT * FROM quizzes WHERE category_id = :categoryId ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Quiz> findRandomQuizByCategoryId(@Param("categoryId") Long categoryId);


    List<Quiz> findByCategory(Category category);
    //List<Quiz> findByCategoryId(Long categoryId);
}
