package com.ibc.pokedex.repositories;

import com.ibc.pokedex.entities.Pokemon;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface PokemonRepository extends CrudRepository<Pokemon, String> {
}
