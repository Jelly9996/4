package com.example.a4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a4.ui.theme._4Theme
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp

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
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Введите натуральное число n:")
    }
}

@Preview(showBackground = true)
@Composable
fun Lab3ScreenPreview() {
    _4Theme {
        Lab3Screen()
    }
}