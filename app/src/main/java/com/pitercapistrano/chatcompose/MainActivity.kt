package com.pitercapistrano.chatcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pitercapistrano.chatcompose.ui.theme.ChatComposeTheme
import com.pitercapistrano.chatcompose.ui.theme.DarkGreen
import com.pitercapistrano.chatcompose.ui.theme.Green
import com.pitercapistrano.chatcompose.ui.theme.White

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatComposeTheme {
                TelaPrincipal()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaPrincipal() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "WhatsApp",
                        style = TextStyle(
                            color = White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Green, navigationIconContentColor = White, actionIconContentColor = White)
            )
        },
        containerColor = White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues) // Use paddingValues para o Scaffold
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            // Adicione conteúdo aqui, se necessário
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChatComposeTheme {
        TelaPrincipal()
    }
}

