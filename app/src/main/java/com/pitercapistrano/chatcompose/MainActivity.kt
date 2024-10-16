package com.pitercapistrano.chatcompose

import android.annotation.SuppressLint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pitercapistrano.chatcompose.itemlista.UsuarioItem
import com.pitercapistrano.chatcompose.model.Usuario
import com.pitercapistrano.chatcompose.ui.theme.ChatComposeTheme
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
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            ListaUsuarios()
        }
    }
}

@Composable
fun ListaUsuarios(){

    val context = LocalContext.current

    val listaUsuarios: MutableList<Usuario> = mutableListOf(
        Usuario("Piter", R.drawable.usuario1),
        Usuario("Sarah", R.drawable.usuario2),
        Usuario("Gilmar", R.drawable.usuario1),
        Usuario("Aline", R.drawable.usuario2),
        Usuario("Carlos", R.drawable.usuario1),
        Usuario("Claudia", R.drawable.usuario2),
        Usuario("Jonas", R.drawable.usuario1),
        Usuario("Carla", R.drawable.usuario2),
        Usuario("Bruno", R.drawable.usuario1),
        Usuario("Barbara", R.drawable.usuario2),
        Usuario("Jhon", R.drawable.usuario1),
        Usuario("Erika", R.drawable.usuario2)
    )
    LazyColumn {
        itemsIndexed(listaUsuarios){position, _ ->
            UsuarioItem(listaUsuarios = listaUsuarios, position = position, context = context)
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

