package com.example.ejercicio_xml;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicioProvincia {
	@GET("ovcswlocalizacionrc/ovccallejero.asmx/ConsultaProvincia")
	Call<Provinciero> pedirProvincias();
	//http://ovc.catastro.meh.es/ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/ConsultaProvincia
}
