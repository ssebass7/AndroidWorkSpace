package com.example.ejercicio_xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="temperatura",strict = false)
public class Temperatura {
    @Element
    private String maxima;
    @Element
    private String minima;

    public String getMaxima() {
        return maxima;
    }

    public void setMaxima(String maxima) {
        this.maxima = maxima;
    }

    public String getMinima() {
        return minima;
    }

    public void setMinima(String minima) {
        this.minima = minima;
    }

    @Override
    public String toString() {
        return  maxima + "-" + minima ;
    }
}
