package com.example.ac2_android_rafael.holders;

import android.view.View;
import android.widget.TextView;

import com.example.ac2_android_rafael.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProdutoHolder extends RecyclerView.ViewHolder  {
    public TextView txtCategoria;
    public TextView txtNome;

    public ProdutoHolder(@NonNull View itemView) {
        super(itemView);
        txtCategoria = (TextView)itemView.findViewById(R.id.textCategoria);
        txtNome = (TextView) itemView.findViewById(R.id.textNome);
    }
}
