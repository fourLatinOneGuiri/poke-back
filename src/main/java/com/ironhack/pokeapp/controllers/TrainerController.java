package com.ironhack.pokeapp.controllers;

import com.ironhack.pokeapp.models.Pokemon;
import com.ironhack.pokeapp.models.Trainer;
import com.ironhack.pokeapp.repositories.TrainerRepository;

import com.ironhack.pokeapp.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainerController {
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    TrainerService trainerService;

    @PostMapping("/trainers/add-trainer")
    @CrossOrigin
    public Trainer addTrainer(@RequestBody  Trainer trainer){
       return trainerService.createTrainer(trainer);
    }

    @GetMapping ("/trainers")
    @CrossOrigin
    public List<Trainer>showAll(){
        return trainerService.getAll();
    }

    @GetMapping("/trainers/{id}")
    @CrossOrigin
    public Trainer getTrainerById (@PathVariable long id){
        return trainerService.getTrainerById(id);
    }

    @DeleteMapping("/trainers/delete/{id}")
    @CrossOrigin
    public List <Trainer> deleteTrainerById (@PathVariable long id){
        trainerService.deleteTrainerById(id);
        return trainerRepository.findAll();
    }

    @PatchMapping("/trainers/{id}/add-pokemon")
    @CrossOrigin
    public void addPokemon(@PathVariable long id, @RequestBody Pokemon pokemon){
        trainerService.addPokemon(id,pokemon);
    }
    @PatchMapping("/trainers/{id}/delete-pokemon/{name}")
    @CrossOrigin
    public void deletePokemon(@PathVariable long id, @PathVariable String name){
        System.out.println("fasdf");
        trainerService.deletePokemon(id,name);
    }
}
