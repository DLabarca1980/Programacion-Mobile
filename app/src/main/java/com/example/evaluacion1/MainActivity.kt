package com.example.evaluacion1

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.String
import kotlin.Double
import android.app.Activity    // Paquetes importados
import java.util.Locale         // Paquetes importados

abstract class Empleado(protected var sueldoBruto: Double) {
    abstract fun calcularLiquido(): Double
}

class EmpleadoHonorarios(montoBruto: Double) : Empleado(montoBruto) {
    override fun calcularLiquido(): Double {
        return sueldoBruto - sueldoBruto * 0.13
    }
}

class EmpleadoRegular(montoBruto: Double) : Empleado(montoBruto) {
    override fun calcularLiquido(): Double {
        return sueldoBruto - sueldoBruto * 0.20
    }

   /* @Composable
    fun PantallaCalculoHonorarios() {
        var sueldoBruto by remember { mutableStateOf("") }
        val sueldoNeto by derivedStateOf {
            if (sueldoBruto.isNotBlank())
                EmpleadoHonorarios(sueldoBruto.toDouble()).calcularLiquido()
            else
                0.0
        }

        Column {
            TextField(
                value = sueldoBruto,
                onValueChange = { sueldoBruto = it },
                label = { Text("Sueldo Bruto") }
            )
            Button(onClick = { /* Calcula y muestra el sueldo neto */ }) {
                Text("Calcular Sueldo Neto")
            }
            Text("Sueldo Neto: $sueldoNeto")
            Button(onClick = { /* Vuelve a la pantalla principal */ }) {
                Text("Volver al Menú")
            }
        }
    } */

    class EmpleadoRegularActivity : Activity() {
            override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_empleado_regular)

            val sueldoBrutoInput: EditText = findViewById(R.id.sueldoBrutoInput)
            val calcularButton: Button = findViewById(R.id.calcularButton)
            val sueldoNetoOutput: TextView = findViewById(R.id.sueldoNetoOutput)
            val volverButton: Button = findViewById(R.id.volverButton)

            calcularButton.setOnClickListener {
                val sueldoBruto = sueldoBrutoInput.text.toString().toDoubleOrNull()
                val sueldoNeto = EmpleadoRegular(sueldoBruto).calcularLiquido()
                sueldoNetoOutput.text = String.format(Locale.US, "%.2f", sueldoNeto)
            }
            volverButton.setOnClickListener { finish() }
        }
    }

}
