package com.example.appcep.retrofit

import com.example.appcep.retrofit.service.CepService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = "https://viacep.com.br/"

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

}