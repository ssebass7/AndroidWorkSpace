package com.example.ejercicio_xml;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServicioMunicipio {
	@GET("ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/ConsultaMunicipio")
	Call<Municipiero> pedirMunicipio(@Query("Provincia") String prov,@Query("Municipio") String n);
}
//http://ovc.catastro.meh.es/ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/ConsultaMunicipio?Provincia=Palencia&Municipio=