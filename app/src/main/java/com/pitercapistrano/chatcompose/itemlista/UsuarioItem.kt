package com.pitercapistrano.chatcompose.itemlista

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.pitercapistrano.chatcompose.model.Usuario
import com.pitercapistrano.chatcompose.ui.theme.Black
import com.pitercapistrano.chatcompose.ui.theme.White

@Composable
fun UsuarioItem(
    listaUsuarios: MutableList<Usuario>,
    position: Int,
    context: Context
) {

    val nome = listaUsuarios[position].nome
    val fotoUsuario = listaUsuarios[position].foto

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
    ) {
        val (txtNome,foto,mensagem,linha) = createRefs()
        
        Image(
            painter = painterResource(id = fotoUsuario!!),
            contentDescription = "Foto do usuario 1!",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .constrainAs(foto) {
                    top.linkTo(parent.top, margin = 20.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                },
            contentScale = ContentScale.Crop
            )

        TextButton(onClick = {
            Toast.makeText(context, "Você clicou no usuário $nome", Toast.LENGTH_SHORT).show()
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = White,
                contentColor = Black
            ),
            modifier = Modifier.constrainAs(txtNome){
                top.linkTo(foto.top)
                start.linkTo(foto.end, margin = 20.dp)
                end.linkTo(parent.end, margin = 20.dp)
            }
        ) {
            Text(
                text = nome!!,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Text(
            text = "Mensagem padrão...",
            fontSize = 14.sp,
            modifier = Modifier.constrainAs(mensagem){
                top.linkTo(txtNome.bottom)
                start.linkTo(foto.end, margin = 20.dp)
                end.linkTo(parent.end, margin = 20.dp)
            }
        )

        Row(
            modifier = Modifier.background(Color.Gray).width(250.dp).height(1.dp).constrainAs(linha){
                top.linkTo(mensagem.bottom, margin = 10.dp)
                start.linkTo(foto.end, margin = 30.dp)
                end.linkTo(parent.end, margin = 20.dp)
            }
        ){

        }
    }
}
