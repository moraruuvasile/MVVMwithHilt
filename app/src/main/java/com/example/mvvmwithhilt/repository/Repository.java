package com.example.mvvmwithhilt.repository;

import com.example.mvvmwithhilt.model.PokemonResponse;
import com.example.mvvmwithhilt.network.PokeApiService;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;


public class Repository {

    private PokeDao pokeDao;
    private PokeApiService apiService;

    @Inject
    public Repository(PokeDao pokeDao, PokeApiService apiService) {
        this.pokeDao = pokeDao;
        this.apiService = apiService;
    }


    public Observable<PokemonResponse> getPokemons() {
        return apiService.getPokemons();
    }
}

