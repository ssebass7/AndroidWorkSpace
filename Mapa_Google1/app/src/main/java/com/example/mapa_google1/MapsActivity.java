package com.example.mapa_google1;

import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.os.Bundle;
import android.service.autofill.FillEventHistory;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Spinner sp_ciudades;
    private OnMapReadyCallback call_Map_Ready;
    private Button myButton;
    private Context c;
    private int posicionSpinner;
    private List<Ciudad> listaCiudad;
    private  Ciudad ciudadObtenida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mi_layout);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        myButton = findViewById(R.id.button);
        sp_ciudades = findViewById(R.id.spinner_ciudades);


        Ciudad madrid = new Ciudad("Madrid", 40, -4);
        Ciudad barcelona  = new Ciudad("Barcelona", 41, 12);
        Ciudad valencia = new Ciudad("Valencia", 39, -1);

        listaCiudad = new ArrayList<>();
        listaCiudad.add(madrid);
        listaCiudad.add(barcelona);
        listaCiudad.add(valencia);



        String[] ciudades = {madrid.getNombre(),barcelona.getNombre(),valencia.getNombre()};
        ArrayAdapter<String> adaptadorCiudades = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, ciudades);
        sp_ciudades.setAdapter(adaptadorCiudades);
        sp_ciudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    posicionSpinner = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.map);
                mapFragment.getMapAsync(MapsActivity.this::onMapReady);
                                            }
                                        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        ciudadObtenida = listaCiudad.get(posicionSpinner);
        // Add a marker in Sydney and move the camera
LatLng city = new LatLng(ciudadObtenida.getLatitud(), ciudadObtenida.getLongitud());
mMap.addMarker(new MarkerOptions().position(city).title(ciudadObtenida.getNombre()));
mMap.moveCamera(CameraUpdateFactory.newLatLng(city));

    }

}