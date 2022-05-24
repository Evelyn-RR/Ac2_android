package com.example.ac2_android_rafael.services;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.ac2_android_rafael.MainActivity;
import com.example.ac2_android_rafael.models.Produto;

public class ListProdutoAsync extends AsyncTask<String,String,String>{
    private String metodo;
    ProgressDialog progressDialog;
    Context context;

    public ListProdutoAsync(String metodo, Context context){
        this.metodo = metodo;
        this.progressDialog = new ProgressDialog(context);
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Carregando...");
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(metodo.equals("GET")){
            ((MainActivity)context).setListaUsuarios(Produto.parseArrayList(s));
            ((MainActivity)context).setupRecyclerUsuario();
            progressDialog.dismiss();
        }
        else if(s.equals("OK")){
            Toast.makeText(context,"Operação realizada com sucesso",Toast.LENGTH_SHORT)
                    .show();
            progressDialog.dismiss();
            ((MainActivity)context).buscarProdutos();
        }

    }
    @Override
    protected String doInBackground(String... strings) {
        String data = "";
        if(metodo.equals("GET"))
            data = ServiceApi.getService(strings[0],strings[1]);
        else if(metodo.equals("DELETE"))
            data = ServiceApi.deleteService(strings[0]);
        return data;
    }

}
