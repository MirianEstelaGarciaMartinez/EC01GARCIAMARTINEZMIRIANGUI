package pe.edu.idat.garcia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Prestamo() {
    Box {
        Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    }
    var monPrestamo by rememberSaveable {
        mutableStateOf("")
    }
    var resultado by rememberSaveable {
        mutableStateOf("")
    }
    Column {
            Text(
                text = "Cálculo de Préstamo",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.Magenta,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp))
            espacion(tamanio = 10)
            OutlinedTextField(value = monPrestamo,
                onValueChange = {monPrestamo=it},
                modifier = Modifier.fillMaxWidth(),
                label={ Text(text = "Ingresar el Monto del préstamo")},
                maxLines=1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            espacion(tamanio = 10)
            Button(onClick = { 
                resultado=CalcularMontoPrestamo(monPrestamo.toDouble())
            },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "Calcular el Monto")
            }
            espacion(tamanio = 10)
            Text(text = resultado)
        }
    }

fun CalcularMontoPrestamo(monto: Double): String {
    val interes =if(monto<400)0.12 else 0.10
    val montInteres=monto*(1+interes)
    val cuotas=when{
        monto > 5000 ->3
        monto < 1000 -> 1
        monto in 2000.0..3000.0 -> 2
        else -> 5
    }
    val valorCuota=montInteres/cuotas
    return "Tienes que pagar en $cuotas cuotas de $valorCuota cada una "
}
