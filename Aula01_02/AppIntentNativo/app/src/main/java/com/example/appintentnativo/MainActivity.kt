package com.example.appintentnativo

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun abrirNavegador(view: View) {
        var intent = Intent(Intent.ACTION_VIEW)
        if (intent.resolveActivity(packageManager) != null) {
            intent.setData(Uri.parse("http://www.senacrs.com.br"))
            startActivity(intent)
        }
    }

    fun realizarChamada(view: View) {
        if(temPermissao()) {
            realizarLigacao("5555")
        }
    }

    fun temPermissao(): Boolean {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                Log.d("PERMISSAO", "Permisso concedida")
                return true;
            }
            else {
                requestPermissions(arrayOf(android.Manifest.permission.CALL_PHONE),1)
            }
        }
        return true;
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    )
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 1){
            if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Log.d("PERMISSAO", "Permissao Concedida!")
                realizarLigacao("5555")
            }
            else {
                Log.d("PERMISSAO", "Permissao Negada!")
            }
        }
    }

    private fun realizarLigacao(numero: String) {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:${numero}")
        startActivity(intent)
    }
}