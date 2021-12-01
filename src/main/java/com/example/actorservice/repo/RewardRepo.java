package com.example.actorservice.repo;

import com.example.actorservice.entity.Reward;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RewardRepo extends CrudRepository<Reward, Long> {
    Optional<Reward> findByTitle(String title);
}
