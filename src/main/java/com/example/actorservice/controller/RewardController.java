package com.example.actorservice.controller;

import com.example.actorservice.entity.Actor;
import com.example.actorservice.entity.Reward;
import com.example.actorservice.exception.EntityNotFound;
import com.example.actorservice.service.ActorService;
import com.example.actorservice.service.RewardService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/reward")
public class RewardController {

    private final RewardService rewardService;
    private final ActorService actorService;

    public RewardController(RewardService rewardService, ActorService actorService) {
        this.rewardService = rewardService;
        this.actorService = actorService;
    }

    @GetMapping
    public Iterable<Reward> getRewards() {
        return rewardService.findAll();
    }

    @GetMapping("/{title}")
    public Reward getReward(@PathVariable String title) {
        return rewardService.findByTitle(title).orElseThrow(() -> new EntityNotFound("reward not found"));
    }

    @PostMapping("/{actor_id}")
    public Reward saveReward(@PathVariable("actor_id") Long id, @Valid Reward reward) {
        Actor actor = actorService.findById(id).orElseThrow(() -> new EntityNotFound("actor not found"));
        reward.setActor(actor);
        return rewardService.save(reward);
    }

    @DeleteMapping("/{reward_id}")
    public ResponseEntity<String> deleteReward(@PathVariable(name="reward_id") Long id) {
        rewardService.remove(id);
        return ResponseEntity.ok("success");
    }

}
