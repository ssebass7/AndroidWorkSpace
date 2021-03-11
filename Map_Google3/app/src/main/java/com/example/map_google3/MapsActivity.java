package com.example.map_google3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,ClasePeticionRetrofit.IMunicipiosRellenos {

    private GoogleMap mMap;
    private Spinner sp_ciudades;
    private OnMapReadyCallback call_Map_Ready;
    private Button myButton;
    Context contexto = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mi_layout);
        sp_ciudades = findViewById(R.id.spinner_ciudades);
        myButton = findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ciudad ciudad_seleccionada = (Ciudad) sp_ciudades.getSelectedItem();
                mostrarMarcador(ciudad_seleccionada, true);
            }
        });
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //Para modificar variables sin getters  ni setters
       /* Ciudad c = new Ciudad();
        Field[] campos = c.getClass().getDeclaredFields();
        try {
            Field campo_nombre = c.getClass().getDeclaredField("city");
            campo_nombre.setAccessible(true);
            campo_nombre.set(c, "MORDOR");
            Log.d("CIUDAD: ", c.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        for (Field f : campos) {
            Log.d("NOMBRE CAMPO:", f.getName());
        }*/
        ClasePeticionRetrofit.pedirMunicipios(this
        );

    }
    private void mostrarMarcador(Ciudad ciudad_seleccionada, boolean borrar_marcador_anterior) {
        double lng = Double.parseDouble(ciudad_seleccionada.getLng());
        double lat = Double.parseDouble(ciudad_seleccionada.getLat());
        MarkerOptions mo = new MarkerOptions().position(new LatLng(lat,lng));
       mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
           @Override
           public boolean onMarkerClick(Marker marker) {
               Ciudad c = (Ciudad) marker.getTag();
               Intent i = new Intent(contexto, ActivityWikipedia.class);
               i.putExtra("ciudad",c.getCity());
               startActivity(i);


            return true;

           }
       });
        if(borrar_marcador_anterior) {
            mMap.clear();
            mMap.addMarker(mo).setTag(ciudad_seleccionada);
        }
    }

    @Override
        public void situarMarcadores (List < Ciudad > ciudades) {
            for (Ciudad c: ciudades){
                mostrarMarcador(c , false);
            }
        }

        @Override
        public void rellenarSpinner (List<Ciudad> ciudades) {
            ArrayAdapter<Ciudad> adaptador = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, ciudades);
            sp_ciudades.setAdapter(adaptador);

    }


}