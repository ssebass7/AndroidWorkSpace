package com.example.map_google3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicioPedirIncidencia {
    //"https://simplemaps.com/static/data/country-cities/es/es.json"
        @GET("static/data/country-cities/es/es.json")
              Call<List<Ciudad>> devolverCiduades();
}
