package com.example.idgs905baseandroid.MultiplicaAporB

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs905baseandroid.Distancia.distancia
import com.example.idgs905baseandroid.R

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)

        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val btnAtras=findViewById<Button>(R.id.btnRegresar)

        val resultado = intent.getStringExtra("RESULTADO")

        txtResultado.text = resultado

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnAtras.setOnClickListener { navegateToAtras() }
    }

    fun navegateToAtras(){
        val intent= Intent(this, AporBActivity::class.java)
        startActivity(
            intent
        )
    }
}