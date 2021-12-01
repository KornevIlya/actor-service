package com.example.actorservice.repo;

import com.example.actorservice.entity.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepo extends CrudRepository<Actor, Long> {
}
