package com.example.ac2_android_rafael.models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Produto {
    private Integer id;
    private String nome;
    private String categoria;

    public Produto() {
    }

    public Produto(Integer id, String nome, String categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    public static Produto parseObject(String json){
        Produto produto = new Produto();
        try{
            JSONObject obj = new JSONObject(json);
            // produto.setId(obj.getInt("id"));
            produto.setNome(obj.getString("nome"));
            produto.setCategoria(obj.getString("categoria"));

            return produto;
        }
        catch (Exception ex){
            return produto;
        }
    }
    public static String parseJson(Produto usuario){
        JSONObject obj = new JSONObject();
        try{
            obj.put("id",""+usuario.getId());
            obj.put("nome",usuario.getNome());
            obj.put("email",usuario.getCategoria());
            return obj.toString();
        }
        catch (Exception ex){
            return "";
        }
    }

    public static ArrayList<Produto> parseArrayList(String json){
        ArrayList<Produto> produtos = new ArrayList<>();
        try{
            JSONArray array = new JSONArray(json);
            for(int i = 0; i < array.length(); i++){
                Produto produto = new Produto();
                JSONObject obj = array.getJSONObject(i);
                produto.setCategoria(obj.getString("categoria"));
                produto.setNome(obj.getString("nome"));
                produto.setId(obj.getInt("id"));
                produtos.add(produto);
            }
            return produtos;
        }
        catch (Exception ex){
            return null;
        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
