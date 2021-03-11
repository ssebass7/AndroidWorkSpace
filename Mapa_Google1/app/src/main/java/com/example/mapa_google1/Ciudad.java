package com.example.mapa_google1;

public class Ciudad {
    private String nombre;
    private int latitud;
    private  int longitud;

    public Ciudad(String nombre, int latitud, int longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLatitud() {
        return latitud;
    }

    public int getLongitud() {
        return longitud;
    }
}
