package com.example.actorservice.controller;

import com.example.actorservice.entity.Movie;
import com.example.actorservice.exception.EntityNotFound;
import com.example.actorservice.service.MovieService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public Iterable<Movie> getMovies() {
        return movieService.findAll();
    }
    @GetMapping("/{movie_id}")
    public Movie getMovie(@PathVariable Long id) {
        return movieService.findById(id).orElseThrow(() -> new EntityNotFound("movie not found"));
    }

    @PostMapping
    public Movie saveMovie(@Valid Movie movie) {
        return movieService.save(movie);
    }

//    @PostMapping("/{person_id}")
//    public Movie save

    @PutMapping
    public Movie updateMovie(@Valid Movie movie) {
        return movieService.save(movie);
    }
}
