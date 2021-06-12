package com.example.appcep.retrofit

import com.example.appcep.retrofit.service.CepService
import com.example.appcep.retrofit.service.ProdutoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//private const val BASE_URL = "https://viacep.com.br"
private const val BASE_URL = "http://10.0.2.2:3000"

class AppRetrofit {

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val cepService by lazy {
        retrofit.create(CepService::class.java)
    }

    val produtoService by lazy {
        retrofit.create(ProdutoService::class.java)
    }

}