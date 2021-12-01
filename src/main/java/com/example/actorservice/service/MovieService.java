package com.example.actorservice.service;

import com.example.actorservice.entity.Movie;

import java.util.Optional;

public interface MovieService {
    Movie save(Movie movie);
    Iterable<Movie> saveAll(Iterable<Movie> movies);
    Optional<Movie> findById(Long id);
    Iterable<Movie> findAll();
    void remove(Long id);
    void remove(Movie movie);
}
