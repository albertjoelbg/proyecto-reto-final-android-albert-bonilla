package proyecto.pokemon.service;

import retrofit.RestAdapter;

/**
 * Created by albertjoel on 17/02/2016.
 */
public class ApiImplementation
{
    private static RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("http://www.victorcasass.com/api/")
            .setLogLevel(RestAdapter.LogLevel.FULL).build();

    public static ApiService getService(){
        return restAdapter.create(ApiService.class);
    }
}
