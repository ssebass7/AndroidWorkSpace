package com.example.provinciamunicipioxml.Temperaturas;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServicioTemp {
    @GET("localidad_{xerx}.xml")
    Call<Prediccion> pedirTiempo(@Path("xerx") String p);
}
