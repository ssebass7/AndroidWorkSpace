package com.example.provinciamunicipioxml.municipio;

import org.simpleframework.xml.Element;

public class Loine {

    @Element(name = "cp")
    private String codProv;
    @Element(name = "cm")
    private String codMuni;


    public Loine(String codProv, String codMuni) {
        super();
        this.codProv = codProv;
        this.codMuni = codMuni;
    }


    public Loine() {
        super();
    }


    public String getCodProv() {
        return codProv;
    }

    public void setCodProv(String codProv) {
        this.codProv = codProv;
    }

    public String getCodMuni() {
        return codMuni;
    }

    public void setCodMuni(String codMuni) {
        this.codMuni = codMuni;
    }

    @Override
    public String toString() {
        return "codProv: " + codProv + ", codMuni: " + codMuni;
    }

}
