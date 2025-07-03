package com.gbueno.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    //this is a one to many relationship
    @OneToMany(mappedBy = "category")
    @JsonIgnore //ignoring for now to prevent infinite loop.  will implement DTOs later
    private Set<Quiz> quizzes;
}
