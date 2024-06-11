package pe.edu.idat.garcia

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Algoritmo() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        var numero by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }
        Column {
            Text(
                text = "Algoritmo vocal correspondiente",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Magenta,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            )
            espacion(tamanio = 10)
            OutlinedTextField(
                value = numero,
                onValueChange = { numero = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingresar un número") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            espacion(tamanio = 10)
            Button(
                onClick = {
                    resultado = obtenerVocal(numero.toIntOrNull())
                },
                modifier = Modifier.fillMaxWidth(),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "Mostrar la Vocal")
            }
            espacion(tamanio = 10)
            Text(text = resultado)
        }
    }
}

fun obtenerVocal(numero: Int?): String {
    return when (numero) {
        1 -> "La vocal correspondiente es A"
        2 -> "La vocal correspondiente es E"
        3 -> "La vocal correspondiente es I"
        4 -> "La vocal correspondiente es O"
        5 -> "La vocal correspondiente es U"
        else -> "Número no válido. Ingrese un número del 1 al 5."
    }
}
