package com.example.actorservice;

import com.example.actorservice.entity.Actor;
import com.example.actorservice.entity.Movie;
import com.example.actorservice.entity.Reward;
import com.example.actorservice.service.ActorService;
import com.example.actorservice.service.MovieService;
import com.example.actorservice.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ActorServiceApplication {

	@Autowired private ActorService actorService;
	@Autowired private MovieService movieService;
	@Autowired private RewardService rewardService;
	public static void main(String[] args) {
		SpringApplication.run(ActorServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			Reward reward = new Reward();
			reward.setTitle("best male actor 2016");
			Reward reward2 = new Reward();
			reward2.setTitle("best male actor 2017");
			Reward reward3 = new Reward();
			reward3.setTitle("best male actor 2018");

			Actor actor = new Actor();
			actor.setFirstName("Jon");
			actor.setLastName("Hall");
			actor.setAge(26);

			Actor actor2 = new Actor();
			actor2.setFirstName("Allan");
			actor2.setLastName("Smith");
			actor2.setAge(42);

			Movie movie = new Movie();
			movie.setTitle("First Class");

			reward.setActor(actor);
			reward2.setActor(actor2);
			reward3.setActor(actor);

			actor.getMovies().add(movie);
			actor2.getMovies().add(movie);

			movie.getActors().add(actor);
			movie.getActors().add(actor2);

			actorService.saveAll(Arrays.asList(actor, actor2));
			rewardService.saveAll(Arrays.asList(reward, reward2, reward3));
		};
	}

}
