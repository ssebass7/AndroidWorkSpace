package com.example.provinciamunicipioxml.Provincias;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicioProv {

    @GET("ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/ConsultaProvincia")
    Call<ConsultaProvinciero> listProvincias();
}
