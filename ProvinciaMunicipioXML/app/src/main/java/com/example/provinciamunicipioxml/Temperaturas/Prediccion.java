package com.example.provinciamunicipioxml.Temperaturas;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class Prediccion {

    @Element(name = "nombre")
    private String nombre;
    @Element(name = "provincia")
    private String nombreProv;
    @ElementList(name = "prediccion")
    private List<Dia> Dia;

    public List<Dia> getDia() {
        return Dia;
    }

    public void setDia(List<Dia> dia) {
        Dia = dia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }
}
