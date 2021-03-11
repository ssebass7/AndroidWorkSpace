package com.example.pruebalocation;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {
    LocationManager lm = null;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
      if (requestCode == 99){
          if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
              //Tengo permiso!!
              obtenerUbicacion();
          }
      }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void obtenerUbicacion() {
        LocationListener oyente_localizaciones = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                Log.d("Localizacion UPDATES: ", location.getLatitude()+"," + location.getLatitude());
                lm.removeUpdates(this);
            }
        };
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //Se que no entra
            return;
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,10,0, oyente_localizaciones);
        Location localizacion_conocida = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (localizacion_conocida != null){
            Log.d("Localizacion CONOCIDA: ", localizacion_conocida.getLatitude()+"," + localizacion_conocida.getLatitude());

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        chequearPermisos();
    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    public void chequearPermisos() {
        //El condicional que si NO tengo permiso FINE y NO tengo permiso COARSE
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
           String[] permisos = {Manifest.permission.ACCESS_FINE_LOCATION};
           requestPermissions(permisos,99);

            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        else{
            obtenerUbicacion();
        }
    }
}