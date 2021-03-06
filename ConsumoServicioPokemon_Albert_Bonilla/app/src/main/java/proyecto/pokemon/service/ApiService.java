package proyecto.pokemon.service;

import java.util.ArrayList;

import proyecto.pokemon.entity.PokemonEntity;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by albertjoel on 17/02/2016.
 */
public interface ApiService
{
    @GET("/lista_pokemons.php")
    void getPokemons(Callback<ArrayList<PokemonEntity>> callback);
}
