package com.gbueno.trivia.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
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
    private Question question;
}
