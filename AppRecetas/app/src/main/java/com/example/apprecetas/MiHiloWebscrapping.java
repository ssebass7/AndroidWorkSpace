package com.example.apprecetas;

import android.os.Handler;
import android.os.Message;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MiHiloWebscrapping implements Runnable {

    private android.os.Handler maneja_mensajes;

    private String ingrediente;

    public MiHiloWebscrapping(Handler h, String ingrediente) {

        this.maneja_mensajes = h;
        this.ingrediente = ingrediente;
    }

    @Override
    public void run() {

        ArrayList<Receta> lista_recetas = new ArrayList<>();
        String ruta = "https://www.recetasderechupete.com/?s=" + ingrediente;

        try {

            Document documento = Jsoup.connect(ruta).get();
            String selector_padre = ".pure-u-1-2.pure-u-lg-1-5";
            Elements lista_elementos_receta = documento.select(selector_padre);
            for (Element elemento_receta: lista_elementos_receta){

                Element elemento_imagen = elemento_receta.selectFirst("img");
                Element elemento_enlace = elemento_receta.selectFirst("a");
                String url_imagen = elemento_imagen.absUrl("src");
                String nombre_receta = elemento_enlace.selectFirst("strong").text();
                String ruta_receta = elemento_enlace.attr("href");
                Receta r = new Receta(nombre_receta, url_imagen, ruta_receta);
                lista_recetas.add(r);


            }
            Message m = new Message();
            m.obj = lista_recetas;
            maneja_mensajes.sendMessage(m);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
