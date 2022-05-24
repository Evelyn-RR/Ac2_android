package com.example.ac2_android_rafael;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ac2_android_rafael.models.Produto;
import com.example.ac2_android_rafael.services.CadProdutoAsync;

public class CadProdutoActivity extends AppCompatActivity {

    int id = 0;
    Produto produto;
    TextView txtCategoria, txtNome;

    public Produto getProduto(){
        return  produto;
    }

    public void setProduto(Produto produto){
        this.produto = produto;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_produto);
        txtCategoria = findViewById(R.id.textCategoria);
        txtNome = findViewById(R.id.textNome);
        if(getIntent().hasExtra("id")){
            id = getIntent().getIntExtra("id",0);
            new CadProdutoAsync("GET", CadProdutoActivity.this).execute("api/produto/" +id,"");
        }
        else
            produto = new Produto();
    }
    public void carregarCampos(){
        txtNome.setText(produto.getNome());
        txtCategoria.setText(produto.getCategoria());
    }

    public void btnSalvarClick(View v){
        produto.setId(id);
        produto.setNome(txtNome.getText().toString());
        produto.setCategoria(txtCategoria.getText().toString());

        if(id > 0){
            new CadProdutoAsync("PUT", CadProdutoActivity.this)
                    .execute("api/produto/" + id,Produto.parseJson(produto));
        }
        else{
            new CadProdutoAsync("POST", CadProdutoActivity.this)
                    .execute("api/produto",Produto.parseJson(produto));
        }

    }
}