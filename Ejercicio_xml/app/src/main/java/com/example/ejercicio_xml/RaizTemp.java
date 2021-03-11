package com.example.ejercicio_xml;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="root",strict = false)
public class RaizTemp {
    @ElementList(name = "prediccion")
    private List<Dias> dias;

    public List<Dias> getDias() {
        return dias;
    }

    public void setDias(List<Dias> dias) {
        this.dias = dias;
    }
}
