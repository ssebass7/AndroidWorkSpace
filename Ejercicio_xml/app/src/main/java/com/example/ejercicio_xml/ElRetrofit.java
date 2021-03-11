package com.example.ejercicio_xml;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class ElRetrofit {

	public static void crearRetrofitProvincia(Comunicacion llamante_provincia) {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://ovc.catastro.meh.es/ovcservweb/")
				.addConverterFactory(SimpleXmlConverterFactory.create()).build();
		ServicioProvincia servicio = retrofit.create(ServicioProvincia.class);
		Call<Provinciero> llamada = servicio.pedirProvincias();
		llamada.enqueue(new Callback<Provinciero>() {

			@Override
			public void onResponse(Call<Provinciero> call, Response<Provinciero> response) {
				Provinciero p = response.body();
				llamante_provincia.mostrarDatos(p);
			}

			@Override
			public void onFailure(Call<Provinciero> call, Throwable t) {
				System.out.println("Error!!!Provincia " + t.getMessage());

			}
		});
	}

	public static void crearRetrofitMunicipio(String prov,Comunicacion llamante_provincia) {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://ovc.catastro.meh.es/")
				.addConverterFactory(SimpleXmlConverterFactory.create()).build();
		ServicioMunicipio servicio = retrofit.create(ServicioMunicipio.class);
		Call<Municipiero> llamada = servicio.pedirMunicipio(prov, "");
		llamada.enqueue(new Callback<Municipiero>() {

			@Override
			public void onResponse(Call<Municipiero> call, Response<Municipiero> response) {
				Municipiero m = response.body();
				llamante_provincia.mostrarDatos2(m, prov);
			}

			@Override
			public void onFailure(Call<Municipiero> call, Throwable t) {
				System.out.println("Error!!!Municipio " + t.getMessage());

			}
		});
	}

	public static void crearRetrofitTemperatura(String codigo,String nomProv,String nomMuni,Comunicacion llamante_provincia) {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.aemet.es/xml/")
				.addConverterFactory(SimpleXmlConverterFactory.create()).build();
		ServicioTemp servicio = retrofit.create(ServicioTemp.class);
		Call<RaizTemp> llamada = servicio.getTemperaturas(codigo);
		llamada.enqueue(new Callback<RaizTemp>() {

			@Override
			public void onResponse(Call<RaizTemp> call, Response<RaizTemp> response) {
				RaizTemp rt = response.body();
				llamante_provincia.mostrarDatos3(rt,nomProv,nomMuni);
			}

			@Override
			public void onFailure(Call<RaizTemp> call, Throwable t) {
				System.out.println("Error!!!Temperatura " + t.getMessage());

			}
		});
	}

	public interface Comunicacion {
		public void mostrarDatos(Provinciero r);
		public void mostrarDatos2(Municipiero m, String prov);
		public void mostrarDatos3(RaizTemp rt,String nomProv,String nomMuni);
	}
}
