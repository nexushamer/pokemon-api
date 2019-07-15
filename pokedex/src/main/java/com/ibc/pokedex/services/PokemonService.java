package com.ibc.pokedex.services;

import com.ibc.pokedex.models.Pokemon;
import com.ibc.pokedex.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepositry;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepositry) {
        this.pokemonRepositry = pokemonRepositry;
    }

    public List<Pokemon> retrieveAllPokemon() {
        return StreamSupport
                .stream(pokemonRepositry.findAll().spliterator(), false)
                .map(pokemon -> {
                    return new Pokemon(pokemon.getId(), pokemon.getName(), pokemon.getType());
                })
                .collect(Collectors.toList());
    }
}
