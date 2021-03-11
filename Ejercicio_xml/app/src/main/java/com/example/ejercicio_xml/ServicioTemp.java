package com.example.ejercicio_xml;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServicioTemp {
    @GET("municipios/localidad_{codigo}.xml")
    Call<RaizTemp> getTemperaturas(@Path("codigo") String codigo);
}
//https://www.aemet.es/xml/municipios/localidad_28034.xml