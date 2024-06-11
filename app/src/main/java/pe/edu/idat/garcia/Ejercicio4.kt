package pe.edu.idat.garcia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import kotlin.math.pow

@Composable
fun LimiteNumero() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        var limite by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(
                text = "Cálcular el limite de número",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color=Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            espacion(tamanio = 10)
            OutlinedTextField(
                value = limite,
                onValueChange = { limite = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingresar el limite de número") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            espacion(tamanio = 10)

            Button(
                onClick = {
                    resultado = calcularLimiteNumero(limite.toIntOrNull())
                },
                modifier = Modifier.fillMaxWidth(),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color.Green,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "CALCULAR")
            }

            espacion(tamanio = 10)

            Text(
                text = resultado,
            )
        }
    }
}

fun calcularLimiteNumero(limite: Int?): String {
    if(limite==null||limite<=0){
        return "Ingresar un número valido como limite"}
    val builder = StringBuilder()
    builder.append("Número\t\tCubo\t\tCuarta\n")
    for (i in 1..limite) {
        val cubo = i.toDouble().pow(3)
        val cuarta = i.toDouble().pow(4)
        builder.append("$i)\t\t${String.format("%.1f", cubo)}\t\t${String.format("%.1f", cuarta)}\n")
    }
    return builder.toString()
}

