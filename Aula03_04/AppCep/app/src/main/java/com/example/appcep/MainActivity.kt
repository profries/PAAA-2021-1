package com.example.appcep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.appcep.retrofit.client.ProdutoClientApi

class MainActivity : AppCompatActivity() {
    val produtoClientApi: ProdutoClientApi by lazy {
        ProdutoClientApi()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun consultarCep (view: View){
        val cepEdit = findViewById<EditText>(R.id.editTextCep)
        val textEstado = findViewById<TextView>(R.id.textEstado)
        val cep = cepEdit.text.toString()
        produtoClientApi.buscarPorId(
                cep,
                onSucess = { produto ->
                    textEstado.text = produto?.nome
                },
                onFail = { erro ->
                    Toast.makeText(this, erro, Toast.LENGTH_SHORT).show()
                }
        )
        /*cepClientApi.buscarCep(
            cep,
            onSucess = { endereco ->
                textEstado.text = endereco?.uf
            },
            onFail = { erro ->
                Toast.makeText(this, erro, Toast.LENGTH_SHORT).show()
            }
        )*/
    }


}