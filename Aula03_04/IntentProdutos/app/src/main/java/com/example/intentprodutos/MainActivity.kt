package com.example.intentprodutos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.intentprodutos.adapter.ProdutoAdapter
import com.example.intentprodutos.model.Produto

class MainActivity : AppCompatActivity() , ProdutoAdapter.OnItemClickListener {
    private var listaProdutos: ArrayList<Produto> = ArrayList()
    private var posicaoAlterar = -1

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: ProdutoAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        viewAdapter = ProdutoAdapter(listaProdutos)
        viewAdapter.onItemClickListener = this


        listaProdutos.add(Produto(1,"Prod1",30.0))
        listaProdutos.add(Produto(2,"Prod2",32.0))
        listaProdutos.add(Produto(3,"Prod3",45.2))
        listaProdutos.add(Produto(4,"Prod4",35.2))
        listaProdutos.add(Produto(5,"Prod5",62.3))
        listaProdutos.add(Produto(6,"Prod6",43.7))
        listaProdutos.add(Produto(7,"Prod7",84.9))

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {

            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun onItemClicked(view: View, position: Int) {
        this.posicaoAlterar = position
        val produto = listaProdutos.get(position)
        val data = Intent().apply {
            putExtra("produtoNome", produto.nome)
        }
        setResult(RESULT_OK, data)
        finish()
    }

}