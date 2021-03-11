package com.example.reclyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Contacto cont1 = new Contacto("Pepe", "pepe@gmail.com", 23);
        Contacto cont2 = new Contacto("Juan", "pepe@gmail.com", 20);
        Contacto cont3 = new Contacto("Jose", "pepe@gmail.com", 34);
        Contacto cont4 = new Contacto("Pedro", "PedroUEM@gmail.com", 28);
        Contacto cont5 = new Contacto("Rosalia", "ros@gmail.com", 23);
        Contacto cont6 = new Contacto("Maria", "galletasMaria@gmail.com", 68);
        Contacto cont7 = new Contacto("Alberto", "MeDasLaVida@gmail.com", 34);
        Contacto cont8 = new Contacto("Mario", "Mariokart@gmail.com", 13);
        Contacto cont9 = new Contacto("Raul", "RaulRodriguez@gmail.com", 39);
        Contacto cont10 = new Contacto("Jaime", "jajajaime@gmail.com", 56);

        ArrayList<Contacto> lista = new ArrayList();
        lista.add(cont1);
        lista.add(cont2);
        lista.add(cont3);
        lista.add(cont4);
        lista.add(cont5);
        lista.add(cont6);
        lista.add(cont7);
        lista.add(cont8);
        lista.add(cont9);
        lista.add(cont10);

        RecyclerView rec = findViewById(R.id.my_recyclerView);
        RecyclerView.LayoutManager gestor = new LinearLayoutManager(this);
        MiAdaptador adaptador = new MiAdaptador(lista);
        rec.setLayoutManager(gestor);
        rec.setAdapter(adaptador);
    }
}