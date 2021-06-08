package com.example.appcep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.appcep.retrofit.CepClientApi

class MainActivity : AppCompatActivity() {
    val cepClientApi: CepClientApi by lazy {
        CepClientApi()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun consultarCep (view: View){
        val cepEdit = findViewById<EditText>(R.id.editTextCep)
        val textEstado = findViewById<TextView>(R.id.textEstado)
        val cep = cepEdit.text.toString()
        cepClientApi.buscarCep(
            cep,
            onSucess = { endereco ->
                textEstado.text = endereco?.uf
            },
            onFail = { erro ->
                Toast.makeText(this, erro, Toast.LENGTH_SHORT).show()
            }
        )
    }


}