package com.example.appcep.retrofit.client

import com.example.appcep.model.Endereco
import com.example.appcep.model.Produto
import com.example.appcep.retrofit.AppRetrofit
import com.example.appcep.retrofit.service.ProdutoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProdutoClientApi (val produtoService: ProdutoService = AppRetrofit().produtoService) {
    fun buscarPorId(
            id: String,
            onSucess: (produto: Produto?) -> Unit,
            onFail: (erro: String?) -> Unit
    ) {
        produtoService.buscarPorId(id).enqueue(object : Callback<Produto> {
            override fun onFailure(call: Call<Produto>, t: Throwable) {
                onFail(t.message)
            }

            override fun onResponse(call: Call<Produto>, response: Response<Produto>) {
                if (response.isSuccessful)
                    onSucess(response.body())
                else
                    onFail("Erro nao identificado!")
            }
        })
    }
}