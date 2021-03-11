package com.example.provinciamunicipioxml.municipio;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServicioMuni {
    @GET("ConsultaMunicipio")
    Call<ConsultaMunicipiero> pedirMunicipio(@Query(value="Provincia") String p, @Query(value= "com/example/provinciamunicipioxml/municipio") String o );
}

