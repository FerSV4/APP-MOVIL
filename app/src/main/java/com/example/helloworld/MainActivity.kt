package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.helloworld.ui.theme.HelloWorldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EjemploRow(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun EjemploRow(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Hola APP",
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = {},
            modifier = Modifier.weight(1f)
        ) {
            Text("UCB")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EjemploRowPreview() {
    HelloWorldTheme {
        EjemploRow()
    }
}
