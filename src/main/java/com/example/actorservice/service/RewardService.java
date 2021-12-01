package com.example.actorservice.service;


import com.example.actorservice.entity.Reward;

import java.util.Optional;

public interface RewardService {
    Reward save(Reward reward);
    Iterable<Reward> saveAll(Iterable<Reward> rewards);
    Optional<Reward> findByTitle(String title);
    Iterable<Reward> findAll();
    void remove(Reward reward);
    void remove(Long id);
}
