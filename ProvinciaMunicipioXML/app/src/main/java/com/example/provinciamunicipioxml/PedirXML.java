package com.example.provinciamunicipioxml;



import com.example.provinciamunicipioxml.Provincias.ConsultaProvinciero;
import com.example.provinciamunicipioxml.Provincias.Provincia;
import com.example.provinciamunicipioxml.Provincias.ServicioProv;
import com.example.provinciamunicipioxml.Temperaturas.Prediccion;
import com.example.provinciamunicipioxml.Temperaturas.ServicioTemp;
import com.example.provinciamunicipioxml.municipio.ConsultaMunicipiero;
import com.example.provinciamunicipioxml.municipio.ServicioMuni;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class PedirXML {
    private static ComunicacionPedirClima clase_llamante;

    public PedirXML(ComunicacionPedirClima clase_llamante) {
        this.clase_llamante = clase_llamante;
    }

    public static void pedirProvincias() {
        String base = "http://ovc.catastro.meh.es/";

        Retrofit retrofit = new Retrofit.Builder().baseUrl(base).addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        ServicioProv servicio = retrofit.create(ServicioProv.class);
        Call<ConsultaProvinciero> llamada = servicio.listProvincias();
        llamada.enqueue(new Callback<ConsultaProvinciero>() {
            @Override
            public void onResponse(Call<ConsultaProvinciero> call, Response<ConsultaProvinciero> response) {
                ConsultaProvinciero r = response.body();
                // System.out.println("Datos: "+r.toString());
                clase_llamante.mostrarDatosSpinner(response.body());

            }

            @Override
            public void onFailure(Call<ConsultaProvinciero> call, Throwable thrwbl) {
                System.out.println("ERROR Provincia: " + thrwbl.getMessage());

            }
        });
    }
    public static void pedirTemperaturas(String Codigo) {
        String base = "http://www.aemet.es/xml/municipios/";

        Retrofit retrofit = new Retrofit.Builder().baseUrl(base).addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        ServicioTemp servicio = retrofit.create(ServicioTemp.class);
        Call<Prediccion> llamada = servicio.pedirTiempo(Codigo);
        llamada.enqueue(new Callback<Prediccion>() {
            @Override
            public void onResponse(Call<Prediccion> call, Response<Prediccion> response) {
                Prediccion r = response.body();
                clase_llamante.mostrarDatosTabla(response.body());

            }

            @Override
            public void onFailure(Call<Prediccion> call, Throwable thrwbl) {
                thrwbl.printStackTrace();

            }
        });
    }

    public static void pedirMunicipio(Provincia prov) {
        String base = "http://ovc.catastro.meh.es/ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/";

        Retrofit retrofit = new Retrofit.Builder().baseUrl(base).addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        ServicioMuni servicio = retrofit.create(ServicioMuni.class);
        Call<ConsultaMunicipiero> llamada = servicio.pedirMunicipio(prov.getNombre(), "");
        llamada.enqueue(new Callback<ConsultaMunicipiero>() {
            @Override
            public void onResponse(Call<ConsultaMunicipiero> call, Response<ConsultaMunicipiero> response) {
                ConsultaMunicipiero r = response.body();
                // System.out.println("Datos: "+r.toString());
                clase_llamante.mostrarDatosSpinner2(response.body());

            }

            @Override
            public void onFailure(Call<ConsultaMunicipiero> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
    }


    public interface ComunicacionPedirClima {
        public void mostrarDatosSpinner(ConsultaProvinciero r);
        public void mostrarDatosTabla(Prediccion r);
        public void mostrarDatosSpinner2(ConsultaMunicipiero r);
    }
}