package com.example.apprecetas;

import java.util.ArrayList;

public class PintarHTML {
    public static String pintarHTML(ArrayList<Receta> lista_recetas){

        String html = "<HTML><head></head><body><table>";
        for (Receta r: lista_recetas){

            html += "<tr><td><img src='"+r.getRuta_imagen()+"'"+
            " width=40px/></td><td><a href='"+r.getEnlace_receta()+"'>"+r.getNombre()+"</a></td></tr>";
        }

        html+="</table";
        html+="</body></html>";
        return html;

    }
}
