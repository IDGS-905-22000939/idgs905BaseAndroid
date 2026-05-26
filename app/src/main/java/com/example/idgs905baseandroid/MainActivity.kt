package com.example.idgs905baseandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs905baseandroid.Ejemplo1.ejemplo1
import com.example.idgs905baseandroid.Distancia.distancia
import com.example.idgs905baseandroid.Ejemplo2.Ejemplo2Activity
import com.example.idgs905baseandroid.MultiplicaAporB.AporBActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnEjemplo1=findViewById<Button>(R.id.btn1)
        val btnEjemplo2=findViewById<Button>(R.id.btn2)
        val btnDistancia=findViewById<Button>(R.id.btn3)
        val btnMulti=findViewById<Button>(R.id.btn4)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnEjemplo1.setOnClickListener { navegateToEjemplo1() }
        btnEjemplo2.setOnClickListener { navegateToEjemplo2() }
        btnDistancia.setOnClickListener { navegateToDistancia() }
        btnMulti.setOnClickListener { navegateToMulti() }
    }
    fun navegateToEjemplo1(){
        val intent= Intent(this, ejemplo1::class.java)
        startActivity(
            intent
        )
    }
    fun navegateToEjemplo2(){
        val intent= Intent(this, Ejemplo2Activity::class.java)
        startActivity(
            intent
        )
    }
    fun navegateToDistancia(){
        val intent= Intent(this, distancia::class.java)
        startActivity(
            intent
        )
    }
    fun navegateToMulti(){
        val intent= Intent(this, AporBActivity::class.java)
        startActivity(
            intent
        )
    }
}