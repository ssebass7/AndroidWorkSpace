package com.example.map_google3;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClasePeticionRetrofit {

    public static void pedirMunicipios(IMunicipiosRellenos clase_llamante){
        Retrofit r = new Retrofit.Builder()
                .baseUrl("https://simplemaps.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        ServicioPedirIncidencia servicio = r.create(ServicioPedirIncidencia.class);
        Call<List<Ciudad>> llamada = servicio.devolverCiduades();
        llamada.enqueue(new Callback<List<Ciudad>>() {
            @Override
            public void onResponse(Call<List<Ciudad>> call, Response<List<Ciudad>> response) {
                Log.d("RESPUESTA",response.body().toString());
                clase_llamante.rellenarSpinner(response.body());
                clase_llamante.situarMarcadores(response.body());

            }

            @Override
            public void onFailure(Call<List<Ciudad>> call, Throwable t) {
                Log.d("ERROR",t.getLocalizedMessage());
            }
        });

    }
    public interface IMunicipiosRellenos{
        public void situarMarcadores(List<Ciudad> ciudades);
        public void rellenarSpinner(List<Ciudad> ciudades);
    }
}
