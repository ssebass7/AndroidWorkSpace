package com.example.botonclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b;
    TextView tv_nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState););
        //getElementById(---)
        setContentView(R.layout.activity_main
        b = findViewById(R.id.btn_clicar);
        tv_nombre = findViewById(R.id.btn_clicar);
        EditText et = findViewById(R.id.et_apellido);
        String apellido = et.getText().toString();
        Log.d("mietiqueta", apellido);
        tv_nombre.setText("hola");
        b.setText("Clicame");
        /*Metodo 1:
        View.onClickListener oyente = new View.OnClickListener(){
    public onClick(View v){
        Log.d("mietiqueta","has clicado el botón");
    }
    boton.setOnclickListener(oyente);
        };*/
    }

}