package com.pitercapistrano.chatcompose.itemlista

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.pitercapistrano.chatcompose.R
import com.pitercapistrano.chatcompose.ui.theme.Black
import com.pitercapistrano.chatcompose.ui.theme.White

@Composable
fun UsuarioItem() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        val (txtNome,foto,mensagem,linha) = createRefs()
        
        Image(
            painter = painterResource(id = R.drawable.usuario1),
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

        },
            colors = ButtonDefaults.buttonColors(
                containerColor = White,
                contentColor = Black
            ),
            modifier = Modifier.constrainAs(txtNome){
                start.linkTo(foto.end, margin = 10.dp)
                top.linkTo(foto.top)
                end.linkTo(parent.end, margin = 20.dp)
            }
        ) {
            Text(
                text = "Piter Capistrano",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Preview
@Composable
fun UsuarioItemPreview(){
    UsuarioItem()
}