package com.ironhack.pokeapp.repositories;

import com.ironhack.pokeapp.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository <Pokemon,String>{
}
