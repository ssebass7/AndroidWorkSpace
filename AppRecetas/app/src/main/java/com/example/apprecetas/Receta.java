package com.example.apprecetas;

public class Receta {
    private String nombre, ruta_imagen, enlace_receta;

    public Receta(String nombre, String ruta_imagen, String enlace_receta) {
        this.nombre = nombre;
        this.ruta_imagen = ruta_imagen;
        this.enlace_receta = enlace_receta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRuta_imagen() {
        return ruta_imagen;
    }

    public String getEnlace_receta() {
        return enlace_receta;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "nombre='" + nombre + '\'' +
                ", ruta_imagen='" + ruta_imagen + '\'' +
                ", enlace_receta='" + enlace_receta + '\'' +
                '}';
    }
}







