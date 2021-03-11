package com.example.provinciamunicipioxml.Temperaturas;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Temperatura {

    @Element(name = "maxima")
    private String tempMax;

    @Element(name = "minima")
    private String tampMin;

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public String getTampMin() {
        return tampMin;
    }

    public void setTampMin(String tampMin) {
        this.tampMin = tampMin;
    }
}
