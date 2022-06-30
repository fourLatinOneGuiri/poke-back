package com.ironhack.pokeapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Pokemon {
    @Id
    @NotNull
    private String name;
    @ManyToMany(mappedBy = "pokemonList")
    @JsonIgnore
    private List<Trainer> trainerList;

    public Pokemon() {
    }

    public Pokemon(String name) {
        setName(name);

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Trainer> getTrainerList() {
        return trainerList;
    }

    public void setTrainerList(List<Trainer> trainerList) {
        this.trainerList = trainerList;
    }
}
