package com.example.provinciamunicipioxml;

public class VerificarCod {
    public static String verifCodigo(String codProv, String codMuni){
        if (codProv.length() != 2){
            codProv = "0" + codProv;
        }
        if (codMuni.length() ==2){
            codMuni = "0" + codMuni;
        }else if (codMuni.length() == 1){
            codMuni = "00" + codMuni;
        }
        String codigoF = codProv+codMuni;
        return codigoF;
        
    }
}
