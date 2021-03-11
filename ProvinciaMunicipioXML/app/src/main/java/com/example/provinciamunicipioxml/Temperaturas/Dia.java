package com.example.provinciamunicipioxml.Temperaturas;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class Dia {

    @Attribute(name = "fecha")
    private String fecha;
    @Element(name = "temperatura")
    private Temperatura temp;



    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Temperatura getTemp() {
        return temp;
    }

    public void setTemp(Temperatura temp) {
        this.temp = temp;
    }

}
