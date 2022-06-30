package com.ironhack.pokeapp.services;

import com.ironhack.pokeapp.models.Pokemon;
import com.ironhack.pokeapp.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    @Autowired
    PokemonRepository pokemonRepository;

}
