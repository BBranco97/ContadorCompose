package br.edu.ifsp.scl.prdm.sc3021131.contadorcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.prdm.sc3021131.contadorcompose.ui.theme.ContadorComposeTheme
import androidx.compose.material3.Text as Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContadorComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContadorComposeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ContadorComposeScreen(modifier: Modifier = Modifier) {
    var initialValue by remember { mutableIntStateOf( 0) }
    var counter by remember { mutableIntStateOf(0) }
    Column (modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    )    {
        OutlinedTextField(
            label= { Text(text = "Initial Value") },
            modifier = Modifier.fillMaxWidth(),
            value = initialValue.toString(),
            onValueChange = { value ->
                initialValue = value.toIntOrNull() ?: 0
                counter = initialValue
            }
        )
        Text(
            text = counter.toString(),
            fontSize = 48.sp,
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {counter++}
        ){
            Text("Increment")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContadorComposeScreenPreview() {
    ContadorComposeTheme {
        ContadorComposeScreen(modifier = Modifier)
    }
}