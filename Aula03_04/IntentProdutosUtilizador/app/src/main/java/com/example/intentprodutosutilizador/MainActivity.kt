package com.example.intentprodutosutilizador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun selecionarProduto (v: View){
        val intent = Intent("ACTION_PICK")

        @Suppress("DEPRECATION")
        startActivityForResult(intent, 1)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        @Suppress("DEPRECATION")
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1 && resultCode == RESULT_OK){
            val produtoNome = data?.getStringExtra("produtoNome")

            val labelProdutoNome = findViewById<TextView>(R.id.produtoNome).apply{
                text = produtoNome
            }

        }

    }
}