package com.gbueno.app.repositories;

import com.gbueno.app.entities.Option;
import com.gbueno.app.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findByQuestion(Question question);
}