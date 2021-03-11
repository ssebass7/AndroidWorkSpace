package com.example.ejrepasoexament2;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap miMapa;
    private Button btn_seguir, btn_reset,btn_ruta_spinner;
    private PolylineOptions ruta = new PolylineOptions();
    private boolean mapaCentrado = false;
    private LocationListener oyente;
    private  LocationManager lm;
    private DatabaseReference myRef;
    private ArrayList listaRuta;
    private ArrayList <PuntoRuta> listaPuntosRuta = new ArrayList();
    private int num = 0;
    private Spinner spinner_rutas;
    private String[] rutas = {"Vacio"};
    private String[] rutas2 = {"Vacio"};
    private Context context = this;
    private ArrayList<String> listaChild = new ArrayList<>();
    private ArrayList<PuntoRuta> listaPuntosRutaSpinner = new ArrayList<>();
    private  int position_spinner;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Rutas");
        btn_seguir = findViewById(R.id.btn_seguir);
        btn_reset = findViewById(R.id.btn_reset);
        btn_ruta_spinner = findViewById(R.id.btn_ruta_spinner);
        spinner_rutas = findViewById(R.id.sp_rutas);

// Attach a listener to read the data at our posts reference
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               for (DataSnapshot valorChild : dataSnapshot.getChildren()){
                   listaChild.add(String.valueOf(valorChild.getKey()));
                }
               rutas = new String[listaChild.size()];

               for(int i = 0; i < listaChild.size(); i++){

                   rutas[i] =  listaChild.get(i);
                }



               ArrayAdapter<String> adaptadorPaises = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, rutas);
               spinner_rutas.setAdapter(adaptadorPaises);

               spinner_rutas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        position_spinner = position;

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Fallo en lectura: " + databaseError.getCode());
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetearRuta();
            }
        });
        btn_seguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pedirActualizaciones();
            }
        });

        btn_ruta_spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int contador = 0;
                        for (DataSnapshot valorChild : dataSnapshot.getChildren()){
                            Log.d("LISTAFIREBASE", valorChild.toString());

                            if(contador == position_spinner) {

                                ArrayList<PuntoRuta> listaPuntosRutaSpinner = (ArrayList<PuntoRuta>) valorChild.getValue();

                                for (int i = 0; i < listaPuntosRutaSpinner.size(); i++) {

                                    listaPuntosRutaSpinner.get(i).getLatitud();
                                    listaPuntosRutaSpinner.get(i).getLongitud();

                                    /*LatLng punto = new LatLng(latitud,longitud);
                                    ruta.add(punto);
                                    miMapa.addPolyline(ruta);
                                    miMapa.moveCamera(CameraUpdateFactory.newLatLngZoom(punto, 8));*/

                                }




                            }

                            contador++;

                        }


                    }






                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("Fallo en lectura: " + databaseError.getCode());
                }
            });


        }
        });

        chekearPermiso();
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
        miMapa = googleMap;
        //Habilitar boton

    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //pedirActualizaciones();
                btn_seguir.setEnabled(true);
            }
        }else{
            btn_seguir.setEnabled(false);
        }
    }


    public void pedirActualizaciones() {
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        oyente = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                meterNuevoPuntoEnRuta(location);
            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 0, oyente);



    }



    private void meterNuevoPuntoEnRuta(Location location) {

        LatLng punto = new LatLng(location.getLatitude(),location.getLongitude());
        PuntoRuta pntRuta = new PuntoRuta(location.getLatitude(),location.getLongitude());
        ruta.add(punto);
        miMapa.addPolyline(ruta);

        listaPuntosRuta.add(pntRuta);

        if (mapaCentrado==false){
            miMapa.moveCamera(CameraUpdateFactory.newLatLngZoom(punto, 8));
            mapaCentrado = true;
        }

        //Centro el mapa en el punto que me ha llegado

    }

    public void resetearRuta() {

        String nombreRuta = ponerNombreRuta();
        myRef.child(nombreRuta).setValue(listaPuntosRuta);

        lm.removeUpdates(oyente);
        ruta = new PolylineOptions();
        miMapa.clear();
    }


    public String ponerNombreRuta(){

        String numAletatorio = String.valueOf(Math.random());
        numAletatorio = numAletatorio.replace(".","");

        String nombreRuta = "Ruta" + numAletatorio;


/*
        if (this.num == 0 ) {
            this.num = this.num + (listaRuta.size() + 2);
        }else {

            this.num = this.num + 1;
        }
            nombreRuta = nombreRuta + "" + this.num;*/

        return nombreRuta;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void chekearPermiso()
    {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions( new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            btn_seguir.setEnabled(false);

        }
        else{
            Log.d("PERMISO","Ya tengo permiso y no hago nada!!");
            btn_seguir.setEnabled(true);
        }
    }
}
