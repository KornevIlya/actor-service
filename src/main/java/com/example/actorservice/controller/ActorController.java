package com.example.actorservice.controller;

import com.example.actorservice.entity.Actor;
import com.example.actorservice.entity.Movie;
import com.example.actorservice.exception.EntityNotFound;
import com.example.actorservice.service.ActorService;
import com.example.actorservice.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private final ActorService actorService;
    private final MovieService movieService;

    public ActorController(ActorService actorService, MovieService movieService) {
        this.actorService = actorService;
        this.movieService = movieService;
    }

    @GetMapping
    public Iterable<Actor> getAllActors() {
        return actorService.findAll();
    }

    @GetMapping("/{actor_id}")
    public Actor getActor(@PathVariable("actor_id") Long id) {
        return actorService.findById(id).orElseThrow(() -> new EntityNotFound("actor not found"));
    }

    @PostMapping
    public Actor saveActor(@Valid Actor actor) {
        return actorService.save(actor);
    }

    @PostMapping("/{movie_id}")
    public Actor saveActorToMovie(@PathVariable("movie_id") Long id, Actor actor) {
        Movie movie = movieService.findById(id).orElseThrow(() -> new EntityNotFound("movie nor found"));
        actor.setMovies(Arrays.asList(movie));
        return actorService.save(actor);
    }

    @PostMapping("{actor_id}/{movie_id}")
    public Actor saveActorToMovie(
            @PathVariable("actor_id") Long actorId,
            @PathVariable("movie_id") Long movieId
    ) {
        Actor actor = actorService.findById(actorId).orElseThrow(() -> new EntityNotFound("actor not found"));
        Movie movie = movieService.findById(movieId).orElseThrow(() -> new EntityNotFound("movie not found"));

        actor.setMovies(Arrays.asList(movie));
        return actorService.save(actor);
    }

    @PutMapping
    public Actor updateActor(@Valid Actor actor) {
        return actorService.save(actor);
    }

    @DeleteMapping("/{actor_id}")
    public ResponseEntity<String> deleteActor(@PathVariable("actor_id") Long id) {
        return ResponseEntity.ok("success");
    }


}
