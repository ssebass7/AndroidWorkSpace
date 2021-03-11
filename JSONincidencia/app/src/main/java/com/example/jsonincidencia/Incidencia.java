package com.example.jsonincidencia;

public class Incidencia {

    private String municipio_distrito;
    private int casos_cofirmados_totales;
    private int casos_confirmados_ultimos_14dias;
    private String fecha_informe;

    public String getMunicipio_distrito() {
        return municipio_distrito;
    }

    public void setMunicipio_distrito(String municipio_distrito) {
        this.municipio_distrito = municipio_distrito;
    }

    public int getCasos_cofirmados_totales() {
        return casos_cofirmados_totales;
    }

    public void setCasos_cofirmados_totales(int casos_cofirmados_totales) {
        this.casos_cofirmados_totales = casos_cofirmados_totales;
    }

    public int getCasos_confirmados_ultimos_14dias() {
        return casos_confirmados_ultimos_14dias;
    }

    public void setCasos_confirmados_ultimos_14dias(int casos_confirmados_ultimos_14dias) {
        this.casos_confirmados_ultimos_14dias = casos_confirmados_ultimos_14dias;
    }

    public String getFecha_informe() {
        return fecha_informe;
    }

    public void setFecha_informe(String fecha_informe) {
        this.fecha_informe = fecha_informe;
    }

    @Override
    public String toString() {
        return "Incidencia{" +
                "municipio_distrito='" + municipio_distrito + '\'' +
                ", casos_cofirmados_totales=" + casos_cofirmados_totales +
                ", casos_confirmados_ultimos_14dias=" + casos_confirmados_ultimos_14dias +
                ", fecha_informe='" + fecha_informe + '\'' +
                '}';
    }
}
