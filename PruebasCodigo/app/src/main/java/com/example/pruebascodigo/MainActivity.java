package com.example.pruebascodigo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Valor vl = new Valor();
        Valor vl2 = new Valor();
        vl.setValor1(1.2222);
        vl.setValor2(3.3333);
        vl2.setValor1(5.5555);
        vl2.setValor2(6.6666);

        ArrayList<Valor> listaValor = new ArrayList<>();
        listaValor.add(vl);
        listaValor.add(vl2);

        for (int i = 0; i <listaValor.size(); i++) {

            double resultado1 = listaValor.get(i).getValor1();
            double resultado2 = listaValor.get(i).getValor2();


        }

    }
}