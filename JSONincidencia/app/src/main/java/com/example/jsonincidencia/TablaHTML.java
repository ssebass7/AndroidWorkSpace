package com.example.jsonincidencia;

import java.util.List;

public class TablaHTML {

    public static String crearTablaHTML(List<Incidencia> lista) {
        String tabla = "<table border = '1'>";
        int cont = 0;
        tabla += "<tr>";
        tabla += "<th style=\'background-color:hsl(46, 100%, 68%)'>" + "DISTRITO" + "</th>";
        tabla += "<th style=\'background-color:hsl(46, 100%, 68%)'>" + "FECHA" + "</th>";
        tabla += "<th style=\'background-color:hsl(46, 100%, 68%)'>" + "CASOS" + "</th>";
        tabla += "</tr>";
        for (Incidencia incidencia : lista) {

            tabla = tabla + "<tr>";
            tabla += "<td style=\'background-color:hsl(71, 100%, 68%)'>" + incidencia.getMunicipio_distrito() + "</td>";
            tabla += "<td style=\'background-color:hsl(164, 100%, 50%)'>" + incidencia.getFecha_informe() + "</td>";
//			tabla += "<td>" + incidencia.getCasos_confirmados_ultimos_14dias() + "</td>";

            tabla += "<td style=\'background-color:"
                    + colorearTabla(lista, incidencia.getCasos_confirmados_ultimos_14dias()) + "'\' >"
                    + incidencia.getCasos_confirmados_ultimos_14dias() + "</td>";
        }
        tabla += "</tr>";

        tabla += "</table>";
        return tabla;

    }

    private static String colorearTabla(List<Incidencia> lista, int datos) {

        float posicion = datos;
        float max = 0;
        float min = lista.get(0).getCasos_confirmados_ultimos_14dias();
        for (int i = 0; i < lista.size() - 1; i++) {
            if (lista.get(i).getCasos_confirmados_ultimos_14dias() > max) {
                max = lista.get(i).getCasos_confirmados_ultimos_14dias();
            }
            if (lista.get(i).getCasos_confirmados_ultimos_14dias() < min) {
                min = lista.get(i).getCasos_confirmados_ultimos_14dias();
            }
        }
        float color = 100 - (100 / (max - min) * posicion + (100 * min / (min - max)));
        String hsl = "hsl(" + color + ",100%,50%)";
        return hsl;
    }
}
