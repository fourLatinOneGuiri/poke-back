package com.ironhack.pokeapp;

import com.ironhack.pokeapp.models.Pokemon;
import com.ironhack.pokeapp.models.Trainer;
import com.ironhack.pokeapp.repositories.PokemonRepository;
import com.ironhack.pokeapp.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokeappApplication implements CommandLineRunner {
	@Autowired
	TrainerRepository trainerRepository;
	@Autowired
	PokemonRepository pokemonRepository;


	public static void main (String[] args){
		SpringApplication.run(PokeappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Trainer trainer = new Trainer("Martina", 22, "unos cuantos", "");
		trainer.getPokemonList().add(new Pokemon("pikachu"));
		trainer.getPokemonList().add(new Pokemon("ditto"));
		trainerRepository.save(trainer);

		Trainer trainer2 = new Trainer("Angelica", 19, "no muchos", "");
		trainer2.getPokemonList().add(new Pokemon("charmeleon"));
		trainer2.getPokemonList().add(new Pokemon("metapod"));
		trainerRepository.save(trainer2);

	}
}
