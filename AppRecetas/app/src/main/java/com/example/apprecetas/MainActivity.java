package com.example.apprecetas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et_ingrediente;
    Button btn_buscar;
    WebView wv_tabla;
    ProgressBar pb_espera;
    Handler manejador_comunicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_ingrediente = findViewById(R.id.et_ingrediente);
        btn_buscar = findViewById(R.id.btn_buscar);
        wv_tabla = findViewById(R.id.wv_tabla);
        pb_espera = findViewById(R.id.pb_esperar);
        manejador_comunicacion = new Handler(getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                //Relleno mi wbview
                pb_espera.setVisibility(View.INVISIBLE);
                btn_buscar.setEnabled(true);
                ArrayList<Receta> lista = (ArrayList<Receta>)msg.obj;
                String html = PintarHTML.pintarHTML(lista);
                wv_tabla.loadData(html, "text/html", "UTF-8");

                Log.d("RECETAS", lista.toString());
            }
        };
        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pb_espera.setVisibility(View.VISIBLE);
                btn_buscar.setEnabled(false);
                // 1-Pillo el ingrediente
                String ingrediente = et_ingrediente.getText().toString();
                //2-Arranco el hilo que hace el webscrapping
                MiHiloWebscrapping mi_runnable = new MiHiloWebscrapping(manejador_comunicacion, ingrediente);
                Thread hilo = new Thread(mi_runnable);
                hilo.start();
            }
        });
    }
}