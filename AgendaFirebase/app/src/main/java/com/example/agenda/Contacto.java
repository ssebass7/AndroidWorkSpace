package com.example.agenda;

public class Contacto {
    private String nombre;
    private String email;

    public Contacto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contacto(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }


}
