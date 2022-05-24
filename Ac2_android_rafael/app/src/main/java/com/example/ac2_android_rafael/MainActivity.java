package com.example.ac2_android_rafael;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ac2_android_rafael.adapters.ProdutoAdapter;
import com.example.ac2_android_rafael.models.Produto;
import com.example.ac2_android_rafael.services.ListProdutoAsync;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Produto> listaProdutos;
    RecyclerView produtoRecycler;
    ProdutoAdapter produtoAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaProdutos = new ArrayList<>();
        produtoRecycler = (RecyclerView) findViewById(R.id.recyclerProduto);
        progressDialog = new ProgressDialog(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        buscarProdutos();
    }

    public void buscarProdutos() {
        new ListProdutoAsync("GET",MainActivity.this).execute("api/produto","");
    }
    public void excluirProduto(String id){
        new ListProdutoAsync("DELETE",MainActivity.this)
                .execute("api/produto/"+id,"");
    }

    public void addProdutoClick(View v){
        Intent i = new Intent(MainActivity.this, CadProdutoActivity.class);
        startActivity(i);
    }

    public void setListaUsuarios(ArrayList<Produto> produtos){
        this.listaProdutos = produtos;
    }
    public void setupRecyclerUsuario(){
        LinearLayoutManager layout = new LinearLayoutManager(this);
        produtoRecycler.setLayoutManager(layout);
        produtoAdapter = new ProdutoAdapter(listaProdutos);
        produtoRecycler.setAdapter(produtoAdapter);

        produtoRecycler.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }
}