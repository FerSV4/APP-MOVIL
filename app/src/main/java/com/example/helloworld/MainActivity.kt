package com.example.helloworld

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloworld.ui.theme.HelloWorldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    PermisosView(modifier = Modifier.padding(padding))
                }
            }
        }
    }
}

@Composable
fun PermisosView(modifier: Modifier = Modifier) {
    val pedirMicrofono = rememberLauncherForActivityResult(RequestPermission()) {}
    val pedirUbicacion = rememberLauncherForActivityResult(RequestPermission()) {}

    Column(modifier = modifier.fillMaxSize().padding(24.dp)) {
        Button(
            onClick = { pedirMicrofono.launch(Manifest.permission.RECORD_AUDIO) },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("Pedir micrófono")
        }
        Button(
            onClick = { pedirUbicacion.launch(Manifest.permission.ACCESS_FINE_LOCATION) },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("Pedir ubicación")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PermisosViewPreview() {
    HelloWorldTheme {
        PermisosView()
    }
}
