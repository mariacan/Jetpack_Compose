package com.example.jetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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

private val messages: List<MyMessage> = listOf(
    MyMessage("Hola Jetpack Compose", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 2", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 3", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 4", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 5", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 6", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 7", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 8", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 9", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 10", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 11", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 12", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 13", "¿Preparado?"))

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
        //Se llama y también se debe poner en el PreviewComponent Para verlo
            JetpackComposeTheme {
                MyMessages(messages)
            }
        }
    }
}       // Abajo empiezan las funciones
data class MyMessage(val title: String, val body: String)

@Composable //Composable = Para pintarse como element basic
fun MyMessages(messages: List<MyMessage>){ //Hace referiencia al supuesto listado de mensajes
    LazyColumn{
        items(messages) { message ->
            MyComponent(message)
        }
    }
}

/*Los modificadores(Modifier) permiten cambiar la apariencia de cada
    uno de nuestros elemntos(tamaños, distancias, colores, funtes)*/
@Composable
fun MyComponent(message: MyMessage){
    Row(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(8.dp)) {
        MyImage()
        MyTexts(message)
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
fun MyTexts(message: MyMessage){
    Column(modifier = Modifier.padding(start = 8.dp)) {
        MyText(
            message.title,
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(16.dp)) //Separación entre columnas
        MyText(
            message.body,
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
@Preview(showSystemUi = true) //Para mostrarlo como emulador virtual
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent (){
    JetpackComposeTheme {
        MyMessages(messages)
    }
}