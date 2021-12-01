package com.example.actorservice.service.impl;

import com.example.actorservice.entity.Reward;
import com.example.actorservice.repo.RewardRepo;
import com.example.actorservice.service.RewardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@Transactional
public class RewardServiceImpl implements RewardService {

    private final RewardRepo rewardRepo;

    @Autowired
    public RewardServiceImpl(RewardRepo rewardRepo) {
        this.rewardRepo = rewardRepo;
    }

    @Override
    public Reward save(Reward reward) {
        log.info("Save reward: {}", reward.getTitle());
        return rewardRepo.save(reward);
    }

    @Override
    public Iterable<Reward> saveAll(Iterable<Reward> rewards) {
        log.info("Save rewards");
        return rewardRepo.saveAll(rewards);
    }

    @Override
    public Iterable<Reward> findAll() {
        log.info("Find all reward");
        return rewardRepo.findAll();
    }

    @Override
    public Optional<Reward> findByTitle(String title) {
        log.info("Find reward by title: {}", title);
        return rewardRepo.findByTitle(title);
    }

    @Override
    public void remove(Long id) {
        log.info("Remove reward by id: {}", id);
        rewardRepo.deleteById(id);
    }

    @Override
    public void remove(Reward reward) {
        log.info("Remove reward: {}", reward.getTitle());
        rewardRepo.delete(reward);
    }
}
