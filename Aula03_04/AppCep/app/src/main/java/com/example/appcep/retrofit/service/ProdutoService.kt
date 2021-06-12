package com.example.appcep.retrofit.service

import com.example.appcep.model.Endereco
import com.example.appcep.model.Produto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProdutoService {
    @GET("/produtos/{id}")
    fun buscarPorId(@Path("id") id: String): Call<Produto>
}