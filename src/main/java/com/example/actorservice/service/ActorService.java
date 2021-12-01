package com.example.actorservice.service;

import com.example.actorservice.entity.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorService {
    Actor save(Actor actor);
    Iterable<Actor> saveAll(Iterable<Actor> actors);
    Optional<Actor> findById(Long id);
    Iterable<Actor> findAll();
    void remove(Actor actor);
    void remove(Long id);
}
