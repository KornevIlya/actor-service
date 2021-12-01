package com.example.actorservice.repo;

import com.example.actorservice.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends CrudRepository<Movie, Long> {
}
