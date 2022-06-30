package com.ironhack.pokeapp.services;

import com.ironhack.pokeapp.models.Pokemon;
import com.ironhack.pokeapp.models.Trainer;
import com.ironhack.pokeapp.repositories.PokemonRepository;
import com.ironhack.pokeapp.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TrainerService {
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    PokemonRepository pokemonRepository;

    public Trainer createTrainer(Trainer trainer){
        if(trainerRepository.findById(trainer.getId()).isPresent()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Trainer ya existe");
        Trainer trainer1 = new Trainer();
        trainer1.setName(trainer.getName());
        trainer1.setAge(trainer.getAge());
        trainer1.setPhoto(trainer.getPhoto());
        trainer1.setHobby(trainer.getHobby());
     return trainerRepository.save(trainer1);
    }

    public List<Trainer> getAll(){
      return  trainerRepository.findAll();
    }

    public Trainer getTrainerById(long id){
        if(!trainerRepository.findById(id).isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Trainer no encontrado");
        return trainerRepository.findById(id).get();
    }

    public void deleteTrainerById(long id){
        if(!trainerRepository.findById(id).isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Trainer no encontrado");
        trainerRepository.deleteById(id);
    }
    public void addPokemon (long id, Pokemon pokemon){
        if(!trainerRepository.findById(id).isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Trainer no encontrado");
        Trainer trainer = trainerRepository.findById(id).get();
        if(!pokemonRepository.findById(pokemon.getName()).isPresent()){
            Pokemon pokemon1 = new Pokemon();
            pokemon1.setName(pokemon.getName());

            pokemonRepository.save(pokemon1);
            trainer.getPokemonList().add(pokemon1);
            trainerRepository.save(trainer);


        }else {Pokemon pokemon1 = new Pokemon();
            pokemon1 = pokemonRepository.findById(pokemon.getName()).get();
        trainer.getPokemonList().add(pokemon1);
        trainerRepository.save(trainer);

        }
    }

    public void deletePokemon(long idTrainer,String name){
        if(!trainerRepository.findById(idTrainer).isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Trainer no encontrado");
        Trainer trainer = trainerRepository.findById(idTrainer).get();
        trainer.getPokemonList().remove(pokemonRepository.findById(name).get());
        trainerRepository.save(trainer);
    }

}
