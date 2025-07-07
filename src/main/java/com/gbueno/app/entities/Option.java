package com.gbueno.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "label")
    private String label;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "question_id")
    //@JsonIgnore //ignoring for now to prevent infinite loop.  will implement DTOs later
    private Question question;
}
