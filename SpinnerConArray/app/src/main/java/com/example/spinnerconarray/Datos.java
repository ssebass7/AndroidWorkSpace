package com.example.spinnerconarray;

import java.util.HashMap;

public class Datos {

    public static HashMap mapDatosPaises(){

        HashMap <Integer, String> mapPais = new HashMap<Integer, String>();
        mapPais.put(0, "España");
        mapPais.put(1, "Francia");
        mapPais.put(2, "Alemania")  ;

        return mapPais;
    }

    public static HashMap mapDatosProvincia(){

        HashMap <Integer, String>mapProvincias = new HashMap<Integer, String>();
        mapProvincias.put(0, "Madrid");
        mapProvincias.put(1, "Segovia");
        mapProvincias.put(2, "Almeria");
        mapProvincias.put(3, "Centre");
        mapProvincias.put(4, "Limousin");
        mapProvincias.put(5, "Auvergne");
        mapProvincias.put(6, "Bayern");
        mapProvincias.put(7, "Thüringen");
        mapProvincias.put(8, "Hessen");

        return mapProvincias;
    }
    public static String[] obtenerProvincia (int position){

        HashMap <Integer, String> mapPaises = mapDatosPaises();
        HashMap <Integer, String> mapProvincia = mapDatosProvincia();
        String[] obtenerProvincia ={};
        if (position == 0) {

            obtenerProvincia = new String[]{mapProvincia.get(position), mapProvincia.get(position + 1), mapProvincia.get(position + 2)};

        } else if (position == 1) {
            obtenerProvincia = new String[]{mapProvincia.get(position + 2), mapProvincia.get(position + 3), mapProvincia.get(position + 4)};
        } else {
            obtenerProvincia = new String[]{mapProvincia.get(position + 4), mapProvincia.get(position+ 5), mapProvincia.get(position + 6)};
        }
        return obtenerProvincia;
    }
    }
