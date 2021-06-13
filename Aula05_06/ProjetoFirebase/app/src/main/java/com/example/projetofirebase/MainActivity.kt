package com.example.projetofirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Firebase.firestore

        db.collection("produtos")
            .get()
            .addOnSuccessListener { result ->
                Toast.makeText(this, "Trazendo a lista com sucesso", Toast.LENGTH_SHORT).show()
                for (document in result) {
                    Log.d("Firebase", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("Firebase", "Error getting documents.", exception)
            }
/*
        // Criacao de um novo produto
        val prod = hashMapOf(
            "nome" to "Produto 3",
            "preco" to 150
        )

        // Add a new document with a generated ID
        db.collection("produtos")
            .add(prod)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(this, "Inserido com sucesso!",Toast.LENGTH_SHORT).show()
                Log.d("Firebase", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Erro!",Toast.LENGTH_SHORT).show()
                Log.w("Firebase", "Error adding document", e)
            }
*/
    }
}