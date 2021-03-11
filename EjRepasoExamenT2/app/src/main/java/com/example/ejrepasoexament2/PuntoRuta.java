package com.example.ejrepasoexament2;

public class PuntoRuta {

    Double latitud, longitud;

    public PuntoRuta(){

    }

    public PuntoRuta(Double latitud, Double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "PuntoRuta{" +
                "latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}
