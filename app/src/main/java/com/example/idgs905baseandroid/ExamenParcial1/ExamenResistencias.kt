package com.example.idgs905baseandroid.ExamenParcial1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs905baseandroid.MainActivity
import com.example.idgs905baseandroid.MultiplicaAporB.AporBActivity
import com.example.idgs905baseandroid.R
import org.w3c.dom.Text

class ExamenResistencias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_examen_resistencias)

        val spinner1 = findViewById<Spinner>(R.id.spinner1)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val spinner3 = findViewById<Spinner>(R.id.spinner3)

        val banda1 = findViewById<TextView>(R.id.banda1)
        val banda2 = findViewById<TextView>(R.id.banda2)
        val banda3 = findViewById<TextView>(R.id.banda3)
        val banda4 = findViewById<TextView>(R.id.banda4)

        val rbOro = findViewById<RadioButton>(R.id.rbOro)
        val rbPlata = findViewById<RadioButton>(R.id.rbPlata)

        val txtOhm = findViewById<TextView>(R.id.txtOhm)
        val txtMax = findViewById<TextView>(R.id.txtMax)
        val txtMin = findViewById<TextView>(R.id.txtMin)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val btnSalir = findViewById<Button>(R.id.btnSalir)

        val colores = arrayOf(
            "Negro",
            "Marrón",
            "Rojo",
            "Naranja",
            "Amarillo",
            "Verde",
            "Azul",
            "Violeta",
            "Gris",
            "Blanco"
        )

        val adapterColores = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            colores
        )

        adapterColores.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spinner1.adapter = adapterColores
        spinner2.adapter = adapterColores
        spinner3.adapter = adapterColores

        spinner1.onItemSelectedListener = colorListener(banda1)
        spinner2.onItemSelectedListener = colorListener(banda2)
        spinner3.onItemSelectedListener = colorListener(banda3)

        rbOro.setOnClickListener {

            banda4.setBackgroundColor(
                Color.rgb(212,175,55)
            )
        }

        rbPlata.setOnClickListener {

            banda4.setBackgroundColor(Color.LTGRAY)
        }

        btnCalcular.setOnClickListener {

            val valor1 = spinner1.selectedItemPosition
            val valor2 = spinner2.selectedItemPosition
            val multiplicador = spinner3.selectedItemPosition

            val numero = "$valor1$valor2".toInt()

            val resultado = numero * Math.pow(10.0, multiplicador.toDouble()).toInt()

            val porcentaje =
                if (rbOro.isChecked) {
                    0.05
                } else {
                    0.10
                }

            val maximo = resultado + (resultado * porcentaje)
            val minimo = resultado - (resultado * porcentaje)

            txtOhm.text = "Valor ohm: $resultado Ω"
            txtMax.text = "Valor máximo: ${maximo.toInt()} Ω"
            txtMin.text = "Valor mínimo: ${minimo.toInt()} Ω"
        }

        btnSalir.setOnClickListener { navegateToSalir() }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun colorListener(vista: TextView):
            AdapterView.OnItemSelectedListener {

        return object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                when(position){

                    0 -> {
                        vista.setBackgroundColor(Color.BLACK)
                        vista.text = "0"
                    }

                    1 -> {
                        vista.setBackgroundColor(
                            Color.rgb(139,69,19)
                        )
                        vista.text = "1"
                    }

                    2 -> {
                        vista.setBackgroundColor(Color.RED)
                        vista.text = "2"
                    }

                    3 -> {
                        vista.setBackgroundColor(
                            Color.rgb(255,165,0)
                        )
                        vista.text = "3"
                    }

                    4 -> {
                        vista.setBackgroundColor(Color.YELLOW)
                        vista.text = "4"
                    }

                    5 -> {
                        vista.setBackgroundColor(Color.GREEN)
                        vista.text = "5"
                    }

                    6 -> {
                        vista.setBackgroundColor(Color.BLUE)
                        vista.text = "6"
                    }

                    7 -> {
                        vista.setBackgroundColor(Color.MAGENTA)
                        vista.text = "7"
                    }

                    8 -> {
                        vista.setBackgroundColor(Color.GRAY)
                        vista.text = "8"
                    }

                    9 -> {
                        vista.setBackgroundColor(Color.WHITE)
                        vista.text = "9"
                    }
                }
            }

            override fun onNothingSelected(
                parent: AdapterView<*>?
            ) {
            }
        }
    }

    fun navegateToSalir(){
        val intent= Intent(this, MainActivity::class.java)
        startActivity(
            intent
        )
    }
}