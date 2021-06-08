package com.example.appfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity(), Comunicador {
    lateinit var mensagem: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fragment_content, PrimeiroFragment())
        ft.commit()
    }
    override fun enviaMensagem(msg: String) {
        mensagem = msg
    }

    fun alterarFragment(view: View) {
// Versao 1 - Sm Comunicacao
/*        var ft = supportFragmentManager.beginTransaction().apply {
            if (view.id == R.id.botaoTela1) {
                replace(R.id.fragment_content, PrimeiroFragment())
            } else if (view.id == R.id.botaoTela2) {
                replace(R.id.fragment_content, SegundoFragment())
            }
            commit()
        }*/

// Versao 2 - Com comunicacao
        var ft = supportFragmentManager.beginTransaction().apply {
            if (view.id == R.id.botaoTela1) {
                replace(R.id.fragment_content, PrimeiroFragment())
            }
            else if (view.id == R.id.botaoTela2){
                var fragment = SegundoFragment()
                var bundle = Bundle().apply {
                    putString("msg", mensagem)
                }
                fragment.arguments = bundle

                replace(R.id.fragment_content, fragment)
            }
            commit()
        }
    }


}

