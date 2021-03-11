package com.example.jsonincidencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView wb = findViewById(R.id.web_view);

        Retrofit r = new Retrofit.Builder()
                .baseUrl("https://datos.comunidad.madrid/catalogo/dataset/")
                .addConverterFactory(GsonConverterFactory.create()).build();
    ServicioPedirIncidencia servicio = r.create(ServicioPedirIncidencia.class);
    Call<Data> llamada = servicio.cogerData();
    llamada.enqueue(new Callback<Data>() {
        @Override
        public void onResponse(Call<Data> call, Response<Data> response) {
            Data d = response.body();
            List<Incidencia> incidencias = d.getData();
            String tabla_pintada = TablaHTML.crearTablaHTML(incidencias);
            wb.loadData( tabla_pintada,"text/html", "UTF-8");
            Log.d("RESPUESTA", response.body().toString());
        }


        @Override
        public void onFailure(Call<Data> call, Throwable t) {
            Log.d("RESPUESTA",t.getLocalizedMessage());
        }
    });
    }
}