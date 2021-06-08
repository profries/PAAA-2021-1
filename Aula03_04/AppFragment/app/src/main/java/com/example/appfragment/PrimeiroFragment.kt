package com.example.appfragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PrimeiroFragment : Fragment() {
    lateinit var comunicador: Comunicador

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate (R.layout.fragment_primeiro, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is Comunicador) {
            comunicador = context as Comunicador
            comunicador.enviaMensagem("Hello Fragment2")
        }


    }

    companion object {
        @JvmStatic
        fun newInstance() = PrimeiroFragment()
    }
}