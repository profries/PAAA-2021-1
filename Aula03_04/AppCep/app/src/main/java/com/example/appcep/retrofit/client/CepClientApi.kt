package com.example.appcep.retrofit.client

import com.example.appcep.model.Endereco
import com.example.appcep.retrofit.AppRetrofit
import com.example.appcep.retrofit.service.CepService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CepClientApi (val cepService: CepService = AppRetrofit().cepService) {
    fun buscarCep(
        cep: String,
        onSucess: (endereco: Endereco?) -> Unit,
        onFail: (erro: String?) -> Unit
    ) {
        cepService.buscarCep(cep).enqueue(object : Callback<Endereco> {
            override fun onFailure(call: Call<Endereco>, t: Throwable) {
                onFail(t.message)
            }

            override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
                if(response.isSuccessful)
                    onSucess(response.body())
                else
                    onFail("Erro nao identificado!")
            }
        })
    }

}