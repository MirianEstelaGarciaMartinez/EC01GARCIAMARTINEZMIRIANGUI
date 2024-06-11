package pe.edu.idat.garcia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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

@Composable
fun espacion(tamanio: Int) {
    Spacer(modifier = Modifier.height(tamanio.dp))

}

//Ejercicio01

@Composable
fun DescuentoAlmacen() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    ) {
        var cantidad by rememberSaveable {
            mutableStateOf("")
        }
        var precio by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Magenta)
            ) {
                Text(
                    text = "Descuento Almacén",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
            espacion(tamanio = 10)
            OutlinedTextField(
                value = cantidad,
                onValueChange = { cantidad = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingresar Cantidad") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            espacion(tamanio = 10)
            OutlinedTextField(
                value = precio,
                onValueChange = { precio = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingresar Precio") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            espacion(tamanio = 10)
            Button(onClick = {
                resultado = calcularDescuento(cantidad.toInt(), precio.toDouble())
            }, Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR DESCUENTO")
            }
            espacion(tamanio = 10)
            Text(text = resultado)
        }
    }
}

fun calcularDescuento(cantidad: Int, precio: Double): String {
    val total=cantidad *precio
    val descuento=if(total>200){
        total*0.02
    }else{
        0.0
    }
    val precioDescuento=total-descuento
    return "Total a pagar después del descuento:$precioDescuento"

}
