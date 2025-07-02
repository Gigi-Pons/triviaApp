package com.gbueno.trivia.repositories;

import com.gbueno.trivia.entities.Question;
import com.gbueno.trivia.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuiz(Quiz quiz);
}
