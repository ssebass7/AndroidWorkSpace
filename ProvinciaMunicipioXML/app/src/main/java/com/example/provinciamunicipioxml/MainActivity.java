package com.example.provinciamunicipioxml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;



import com.example.provinciamunicipioxml.Provincias.ConsultaProvinciero;
import com.example.provinciamunicipioxml.Provincias.Provincia;
import com.example.provinciamunicipioxml.Temperaturas.Prediccion;
import com.example.provinciamunicipioxml.municipio.ConsultaMunicipiero;
import com.example.provinciamunicipioxml.municipio.Municipio;


import java.util.ArrayList;



public class MainActivity extends AppCompatActivity implements PedirXML.ComunicacionPedirClima {

    private Context context = this;
    private Spinner spProv;
    private Spinner spMuni;
    private PedirXML es;
    private String codProv;
    private String codMuni;
    private WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spProv = findViewById(R.id.spinnerProvincia);
        spMuni = findViewById(R.id.spinnerMuni);
        wb = findViewById(R.id.webV);
        es = new PedirXML(MainActivity.this);
        PedirXML.pedirProvincias();
        spProv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                PedirXML.pedirMunicipio((Provincia)(parent.getItemAtPosition(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spMuni.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Municipio m =  (Municipio)(parent.getItemAtPosition(position));
                codMuni = m.getLoine().getCodMuni();
                codProv = m.getLoine().getCodProv();
                String codigoPostal = VerificarCod.verifCodigo(codProv,codMuni);
                PedirXML.pedirTemperaturas(codigoPostal);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }

    @Override
    public void mostrarDatosSpinner(ConsultaProvinciero r) {
        ArrayList<Provincia> nombres = new ArrayList<Provincia>();
        for (Provincia p : r.getProvinciero()){
            nombres.add(p);
        }
        ArrayAdapter<Provincia> adaptador = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,nombres);
        spProv.setAdapter(adaptador);
    }

    @Override
    public void mostrarDatosTabla(Prediccion r) {
        String tabla = PintarHTML.getTabla(r);
        wb.loadData(tabla,"text/html","UTF-8");
    }

    @Override
    public void mostrarDatosSpinner2(ConsultaMunicipiero r) {
        ArrayList<Municipio> nombres = new ArrayList<Municipio>();
        for (Municipio p : r.getmunicipiero()){
            nombres.add(p);
        }
        ArrayAdapter<Municipio> adaptador = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,nombres);
        spMuni.setAdapter(adaptador);

    }
}