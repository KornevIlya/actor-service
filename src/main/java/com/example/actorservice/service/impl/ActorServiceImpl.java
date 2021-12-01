package com.example.actorservice.service.impl;

import com.example.actorservice.entity.Actor;
import com.example.actorservice.repo.ActorRepo;
import com.example.actorservice.service.ActorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@Transactional
public class ActorServiceImpl implements ActorService {

    private final ActorRepo actorRepo;

    @Autowired
    public ActorServiceImpl(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }

    @Override
    public Actor save(Actor actor) {
        log.info("Save actor: {} {}", actor.getFirstName(), actor.getLastName());
        return actorRepo.save(actor);
    }

    @Override
    public Iterable<Actor> saveAll(Iterable<Actor> actors) {
        log.info("Save all actors");
        return actorRepo.saveAll(actors);
    }

    @Override
    public Optional<Actor> findById(Long id) {
        log.info("Find by id: {}", id);
        return actorRepo.findById(id);
    }

    @Override
    public Iterable<Actor> findAll() {
        log.info("Find all actors");
        return actorRepo.findAll();
    }

    @Override
    public void remove(Long id) {
        log.info("remove by id: {}", id);
        actorRepo.deleteById(id);
    }

    @Override
    public void remove(Actor actor) {
        log.info("remove actor: {} {}", actor.getFirstName(), actor.getLastName());
        actorRepo.delete(actor);
    }
}
