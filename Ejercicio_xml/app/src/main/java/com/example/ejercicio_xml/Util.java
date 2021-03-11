package com.example.ejercicio_xml;

import android.util.Log;

public class Util {
    public static String mirarCodigo(String codProv, String codMuni) {
        String codTotal = "";
        String codProvBueno = codProv;
        String codMuniBueno= "";
        if (codProv.length() != 2){
            codProvBueno = "0" + codProv;
        }
        if (codMuni.length() == 3){
            codMuniBueno = codMuni;
        }else if (codMuni.length()==2){
            codMuniBueno = "0" + codMuni;
        }else{
            codMuniBueno = "00" + codMuni;
        }
        codTotal = codProvBueno + codMuniBueno;
        return codTotal;
    }
}
