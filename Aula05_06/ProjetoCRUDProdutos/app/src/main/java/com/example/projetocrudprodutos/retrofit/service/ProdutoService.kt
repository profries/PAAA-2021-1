package com.example.projetocrudprodutos.retrofit.service

import com.example.projetocrudprodutos.model.Produto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProdutoService {
    @GET("/produtos")
    fun listarProdutos(): Call<List<Produto>>

    @GET("/produtos/{id}")
    fun buscarPorId(@Path("id") id: String): Call<Produto>
}