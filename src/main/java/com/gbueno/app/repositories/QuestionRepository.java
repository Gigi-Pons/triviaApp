package com.gbueno.app.repositories;

import com.gbueno.app.entities.Question;
import com.gbueno.app.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuiz(Quiz quiz);
}
