package com.example.a4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a4.ui.theme._4Theme
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Lab3Screen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}   // <- класс закончился здесь

@Composable
fun Lab3Screen(modifier: Modifier = Modifier) {
    var nText by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("Результат:") }
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Введите натуральное число n:")
        OutlinedTextField(
            value = nText,
            onValueChange = { nText = it },
            label = { Text("n") }
        )
        Button(
            onClick = {
                resultText = "n = $nText"
                val n = nText.toInt()
                var sumSin = 0.0   // sin1 + sin2 + ... + sin k
                var result = 0.0   // итоговая сумма дробей

                for (k in 1..n) {
                    sumSin = sumSin + Math.sin(k.toDouble())
                    result = result + 1 / sumSin
                }

                resultText = "Результат: $result"
                 },
            modifier = Modifier.padding(top = 8.dp)
                   ) {
            Text("Вычислить")
        }

        Text(
            text = resultText,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Lab3ScreenPreview() {
    _4Theme {
        Lab3Screen()
    }
}