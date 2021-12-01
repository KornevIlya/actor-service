package com.example.actorservice.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Reward {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Title is mandatory")
    private String title;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;
}
