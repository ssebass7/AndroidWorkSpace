package com.example.provinciamunicipioxml.municipio;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "consulta_Municipiero", strict = false)

public class ConsultaMunicipiero {

    @ElementList
    private List<Municipio> municipiero;

    public List<Municipio> getmunicipiero() {
        return municipiero;
    }

    public void setmunicipiero(List<Municipio> municipiero) {
        this.municipiero = municipiero;
    }

    @Override
    public String toString() {
        return  " " + municipiero ;
    }

}
