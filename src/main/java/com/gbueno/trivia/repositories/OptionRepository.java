package com.gbueno.trivia.repositories;

import com.gbueno.trivia.entities.Option;
import com.gbueno.trivia.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OptionRepository extends JpaRepository<Option, UUID> {
    List<Option> findByQuestion(Question question);
}
