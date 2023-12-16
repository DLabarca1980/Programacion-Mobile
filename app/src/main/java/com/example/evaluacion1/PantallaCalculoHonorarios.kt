package com.example.evaluacion1


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.evaluacion1.ui.theme.Evaluacion1Theme

/*class PantallaCalculoHonorariosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaCalculoHonorarios()
        }
    }
} */




@Composable
fun PantallaCalculoHonorarios() {
    var sueldoBruto by remember { mutableStateOf("") }
    val sueldoNeto by derivedStateOf {
        if (sueldoBruto.isNotBlank()) EmpleadoHonorarios(sueldoBruto.toDouble()).calcularLiquido()
        else
            0.0
    }

    Column {
        TextField(
            value = sueldoBruto,
            onValueChange = { sueldoBruto = it },
            label = { Text("Sueldo Bruto")

            }
        )
        Button(onClick = { "Calcular" /* Calcula y muestra el sueldo neto */ }) {
            Text("Calcular Sueldo Neto")
        }
        Text("Sueldo Neto: $sueldoNeto")
        Button(onClick = { "Volver"/* Vuelve a la pantalla principal */ }) {
            Text("Volver al Menú")
        }
    }
}

fun Button(onClick: () -> String, function: () -> Unit) {

}
