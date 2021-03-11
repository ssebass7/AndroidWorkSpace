package com.example.spinnerconarray;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.HashMap;
import java.util.SplittableRandom;

public class MainActivity extends AppCompatActivity {

    Spinner spinner_paises;
    static Spinner spinner_provincias;
    static String[] provinciaEsp;
    static String[] provinciaFran;
    static String[] provinciaAlem;
    static String[] provincias;
    Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner_paises = findViewById(R.id.sp_paises);
        spinner_provincias = findViewById(R.id.sp_provincias);

        Datos dat = new Datos();
        HashMap <Integer, String> mapPaises = dat.mapDatosPaises();
        String[] paises = {mapPaises.get(0),mapPaises.get(1),mapPaises.get(2)};
        provincias = new String[]{};

        ArrayAdapter<String> adaptadorPaises = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, paises);
        spinner_paises.setAdapter(adaptadorPaises);

        spinner_paises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Datos dat = new Datos();
             provincias = dat.obtenerProvincia(position);
                ArrayAdapter<String> adaptadorProvincias = new ArrayAdapter<>(c, R.layout.support_simple_spinner_dropdown_item, provincias);
                spinner_provincias.setAdapter(adaptadorProvincias);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
    }

}