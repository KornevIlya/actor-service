package com.example.actorservice.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Title is mandatory")
    private String title;

    @ManyToMany(mappedBy = "movies", cascade = CascadeType.ALL)
    private List<Actor> actors = new ArrayList<>();
}
