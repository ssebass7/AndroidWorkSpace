package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnAceptar;
    EditText etxtNombre;
    EditText etxtEmail;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAceptar = findViewById(R.id.btAceptar);
        etxtNombre = findViewById(R.id.etNombre);
        etxtEmail = findViewById(R.id.etEmail);
        ArrayList<Contactos> listaContactos = new ArrayList<>();

        btnAceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nombre = String.valueOf(etxtNombre.getText());
                String email = String.valueOf(etxtEmail.getText());
                Contactos c1 = new Contactos(nombre, email);

                FirebaseDatabase bd = FirebaseDatabase.getInstance("https://agenda-9cf6d-default-rtdb.europe-west1.firebasedatabase.app/");
                DatabaseReference referencia = bd.getReference("Usuarios");
                referencia.push().setValue(c1);

                listaContactos.add(c1);

                RecyclerView rec = findViewById(R.id.my_recycler);
                RecyclerView.LayoutManager gestor = new LinearLayoutManager(context);
                RecyclerViewActivity adaptador = new RecyclerViewActivity(listaContactos);
                rec.setLayoutManager(gestor);
                rec.setAdapter(adaptador);

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);


            }
        });


    }

    public void obtenerValoresFirebase(ArrayList listaContactos, Context con){
        RecyclerView rec = findViewById(R.id.my_recycler);
        RecyclerView.LayoutManager gestor = new LinearLayoutManager(con);
        RecyclerViewActivity adaptador = new RecyclerViewActivity(listaContactos);
        rec.setLayoutManager(gestor);
        rec.setAdapter(adaptador);
    }
}