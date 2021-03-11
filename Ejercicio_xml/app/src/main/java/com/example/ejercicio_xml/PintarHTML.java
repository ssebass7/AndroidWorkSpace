package com.example.ejercicio_xml;

import java.util.List;

public class PintarHTML {

    public static String pintarTabla(List<Dias> dia, String nomProv, String nomMuni) {
        String titulo = "<h1>" + "Tabla de " + nomMuni + " en " + nomProv + "</h1>";
        String tabla = "<table border=2px>";
        tabla += "<tr>";
        tabla += "<th>" + "Fecha" + "</th>";
        tabla += "<th>" + "Maxima" + "</th>";
        tabla += "<th>" + "Minima" + "</th>";
        tabla += "</tr>";
        for (Dias d : dia) {
            tabla += "<tr>";
            tabla += "<td>" + d.getFecha() + "</td>";
            tabla += "<td>" + d.getTemperatura().getMaxima() + "</td>";
            tabla += "<td>" + d.getTemperatura().getMinima() + "</td>";
            tabla += "</tr>";
        }
        tabla += "</table>";
        return titulo + tabla;
    }
}
