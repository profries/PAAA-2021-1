package com.example.projetocrudprodutos.retrofit.client

import com.example.projetocrudprodutos.model.Produto
import com.example.projetocrudprodutos.retrofit.AppRetrofit
import com.example.projetocrudprodutos.retrofit.service.ProdutoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProdutoClientApi (val produtoService: ProdutoService = AppRetrofit().produtoService) {

    fun listar(
        onSuccess: (produtos: List<Produto>?) -> Unit,
        onFail: (erro: String?) -> Unit
    ) {
        produtoService.listarProdutos().enqueue(object : Callback<List<Produto>> {
            override fun onFailure(call: Call<List<Produto>>, t: Throwable) {
                onFail(t.message)
            }

            override fun onResponse(call: Call<List<Produto>>, response: Response<List<Produto>>) {
                if (response.isSuccessful)
                    onSuccess(response.body())
                else
                    onFail("Erro nao identificado!")
            }
        })
    }

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