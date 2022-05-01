package com.example.jetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
        //Se llama y también se debe poner en el PreviewComponent Para verlo
            JetpackComposeTheme {
                MyComponent()
            }
        }
    }
} /*Los modificadores(Modifier) permiten cambiar la apariencia de cada
    uno de nuestros elemntos(tamaños, distancias, colores, funtes)*/
@Composable
fun MyComponent(){
    Row(modifier = Modifier.background(MaterialTheme.colors.background)
        .padding(8.dp)) {
        MyImage()
        MyTexts()
    }
}

//Add Image
@Composable//Sustetible
fun MyImage(){
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        "My Image de prueba",
        modifier = Modifier //La image se modifica:
            .size(64.dp) //El tamaño
            .clip(CircleShape) //Su forma (es redonda)
            .background(MaterialTheme.colors.primary) //Con un fondo color
    )
}
//Mostrarlo de manera ordenada en una columna (Uno debajo del otro)
@Composable
fun MyTexts(){
    Column(modifier = Modifier.padding(start = 8.dp)) {
        MyText("¡Hola Jetpack Compose!",
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(16.dp)) //Separación entre columnas
        MyText("¿Preparado?",
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.subtitle2
        )
    }
}

//Esto es un elemento gráfico
@Composable
fun MyText(text: String, color: Color, style: androidx.compose.ui.text.TextStyle){
    Text(text, color = color, style = style)
}
//PREVIEW VISUALIZER
@Preview()
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent (){
    JetpackComposeTheme {
        MyComponent()
    }
}