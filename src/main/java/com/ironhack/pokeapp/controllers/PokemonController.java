package com.ironhack.pokeapp.controllers;

import com.ironhack.pokeapp.repositories.PokemonRepository;

import com.ironhack.pokeapp.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

    @Autowired
    PokemonRepository pokemonRepository;
    @Autowired
    PokemonService pokemonService;
}
