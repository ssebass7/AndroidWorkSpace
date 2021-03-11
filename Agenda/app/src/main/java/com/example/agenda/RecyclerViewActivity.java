package com.example.agenda;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewActivity extends RecyclerView.Adapter<RecyclerViewActivity.MiContenedorDeVistas> {

    private ArrayList<Contactos> listaContactos = new ArrayList<>();

    public  RecyclerViewActivity(ArrayList<Contactos> listaContactos) {
        this.listaContactos = listaContactos;
    }

    @NonNull
    @Override
    public MiContenedorDeVistas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_contactos, parent, false);
        TextView tv_nombre = vista.findViewById(R.id.textNombre);
        TextView tv_email = vista.findViewById(R.id.textEmail);
        MiContenedorDeVistas contenedor = new MiContenedorDeVistas(vista);
        Log.d("contenedor", "creando contenedor de vistas");
        return contenedor;
    }

    @Override
    public void onBindViewHolder(@NonNull MiContenedorDeVistas holder, int position) {
        Contactos c = listaContactos.get(position);
        holder.tv_nombre.setText((c.getNombre()));
        holder.tv_email.setText(c.getEmail());
        Log.d("contenedor", "vinculando posicion" + position);
    }

    @Override
    public int getItemCount() {
        return listaContactos.size();
    }

    public static class MiContenedorDeVistas extends RecyclerView.ViewHolder {
        public TextView tv_nombre, tv_email;

        public MiContenedorDeVistas(View vista) {
            super(vista);
            this.tv_nombre = vista.findViewById(R.id.textNombre);
            this.tv_email = vista.findViewById(R.id.textEmail);
        }

    }
}