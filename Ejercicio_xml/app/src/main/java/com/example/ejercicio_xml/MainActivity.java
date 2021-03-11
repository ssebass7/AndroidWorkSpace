package com.example.ejercicio_xml;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ElRetrofit.Comunicacion{
Spinner spn_provincia;
Spinner spn_municipio;
String codProv;
String codMuni;
String nomMuni;
String nomProv;
String tabla;
WebView wv;
ElRetrofit.Comunicacion a = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn_provincia = findViewById(R.id.spn_provincias);
        spn_municipio = findViewById(R.id.spn_municipios);
        wv = findViewById(R.id.web_View);
        ElRetrofit.crearRetrofitProvincia(a);
        spn_provincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nombre = parent.getItemAtPosition(position).toString();
                ElRetrofit.crearRetrofitMunicipio(nombre,a);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spn_municipio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                codProv = ((Municipio) spn_municipio.getSelectedItem()).getLoine().getCodigo_provincia();
                codMuni = ((Municipio) spn_municipio.getSelectedItem()).getLoine().getCodigo_municipio();
                String codTotal = Util.mirarCodigo(codProv,codMuni);
                nomMuni = ((Municipio) spn_municipio.getSelectedItem()).getNombre();
                ElRetrofit.crearRetrofitTemperatura(codTotal,nomProv,nomMuni,a);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void mostrarDatos(Provinciero r) {
        List<Provincia> provincias = r.getProvincias();
        ArrayAdapter<Provincia>adaptador_provincias = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,provincias);
        spn_provincia.setAdapter(adaptador_provincias);
    }

    @Override
    public void mostrarDatos2(Municipiero m, String prov) {
        List<Municipio> municipios = m.getMunicipios();
        nomProv = prov;
        ArrayAdapter<Municipio> adaptador_municipio = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,municipios);
        spn_municipio.setAdapter(adaptador_municipio);
    }

    @Override
    public void mostrarDatos3(RaizTemp rt,String nomProv,String nomMuni) {
        List<Dias> dia = rt.getDias();
        tabla = PintarHTML.pintarTabla(dia,nomProv,nomMuni);
        wv.loadData(tabla,"text/html","UTF-8");
    }
}