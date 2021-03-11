package com.example.reclyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiContenedorDeVistas> {

    private ArrayList<Contacto> lista_contactos;

    public MiAdaptador(ArrayList<Contacto> lista_contactos) {
        this.lista_contactos = lista_contactos;
    }

    @NonNull
    @Override
    public MiContenedorDeVistas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_contacto,parent, false);
      MiContenedorDeVistas contenedor = new MiContenedorDeVistas(vista);
        Log.d(" Contenedor", "Creando Contenedor de vistas");
      return contenedor;
    }

    @Override
    public void onBindViewHolder(@NonNull MiContenedorDeVistas holder, int position) {
    Contacto c = lista_contactos.get(position);
    holder.tv_nombre.setText(c.getNombre());
    holder.tv_email.setText(c.getEmail());
    holder.tv_edad.setText(String.valueOf(c.getEdad()));
        Log.d(" Contenedor","Vinculando la posicion" + position);
    }

    @Override
    public int getItemCount() {
        return lista_contactos.size();
    }

    public static class MiContenedorDeVistas extends RecyclerView.ViewHolder{
      public TextView tv_nombre, tv_email, tv_edad;

        public MiContenedorDeVistas(View vista) {
            super(vista);
            this.tv_nombre = vista.findViewById(R.id.tv_nombre);
            this.tv_email = vista.findViewById(R.id.tv_email);
            this.tv_edad = vista.findViewById(R.id.tv_edad);
        }
    }


}
