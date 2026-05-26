package com.example.idgs905baseandroid.Distancia

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs905baseandroid.R
import kotlin.math.pow
import kotlin.math.sqrt

class distancia : AppCompatActivity() {

    lateinit var edtX1: EditText
    lateinit var edtY1: EditText
    lateinit var edtX2: EditText
    lateinit var edtY2: EditText
    lateinit var btnCalcular: Button
    lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtX1 = findViewById<EditText>(R.id.edtX1)
        val edtY1 = findViewById<EditText>(R.id.edtY1)
        val edtX2 = findViewById<EditText>(R.id.edtX2)
        val edtY2 = findViewById<EditText>(R.id.edtY2)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnCalcular.setOnClickListener {

            val x1 = edtX1.text.toString().toDouble()
            val y1 = edtY1.text.toString().toDouble()
            val x2 = edtX2.text.toString().toDouble()
            val y2 = edtY2.text.toString().toDouble()

            val resultado = calcularDistancia(x1, y1, x2, y2)

            txtResultado.text = "Resultado: " + resultado
        }
    }
    fun calcularDistancia(
        x1: Double,
        y1: Double,
        x2: Double,
        y2: Double
    ): Double {

        return sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)))
    }
}