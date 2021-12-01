package com.example.actorservice.service.impl;

import com.example.actorservice.entity.Movie;
import com.example.actorservice.repo.MovieRepo;
import com.example.actorservice.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@Transactional
public class MovieServiceImpl implements MovieService {
    private final MovieRepo movieRepo;

    public MovieServiceImpl(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public Movie save(Movie movie) {
        log.info("Save movie: {}", movie.getTitle());
        return movieRepo.save(movie);
    }

    @Override
    public Iterable<Movie> saveAll(Iterable<Movie> movies) {
        log.info("Save all movies");
        return movieRepo.saveAll(movies);
    }

    @Override
    public Optional<Movie> findById(Long id) {
        log.info("Find movie by id: {}", id);
        return movieRepo.findById(id);
    }

    @Override
    public Iterable<Movie> findAll() {
        log.info("Find all movies");
        return movieRepo.findAll();
    }

    @Override
    public void remove(Long id) {
        log.info("Remove movie by id: {}", id);
        movieRepo.deleteById(id);
    }

    @Override
    public void remove(Movie movie) {
        log.info("Remove movie: {}", movie.getTitle());
        movieRepo.delete(movie);
    }
}
