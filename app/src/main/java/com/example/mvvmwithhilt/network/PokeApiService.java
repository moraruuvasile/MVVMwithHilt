package com.example.mvvmwithhilt.network;

import com.example.mvvmwithhilt.model.PokemonResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PokeApiService {

    @GET("pokemon")
    Observable<PokemonResponse> getPokemons();
}
