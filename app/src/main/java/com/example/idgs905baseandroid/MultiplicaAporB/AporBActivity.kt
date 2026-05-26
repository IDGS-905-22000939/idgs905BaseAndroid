package com.example.idgs905baseandroid.MultiplicaAporB

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs905baseandroid.R

class AporBActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_apor_bactivity)

        val txtA = findViewById<EditText>(R.id.txtA)
        val txtB = findViewById<EditText>(R.id.txtB)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener {

            val a = txtA.text.toString().toInt()
            val b = txtB.text.toString().toInt()
            var suma = ""
            var resultado = 0

            for (i in 1..b) {
                suma = suma + a
                if (i < b) {
                    suma = suma + "+"
                }
                resultado = resultado + a
            }

            val texto = suma + " = " + resultado
            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("RESULTADO", texto)

            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}