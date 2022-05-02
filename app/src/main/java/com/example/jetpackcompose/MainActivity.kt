package com.example.jetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import java.time.format.TextStyle

private val messages: List<MyMessage> = listOf(
    MyMessage("Hola Jetpack Compose 1", "¿Preparado? 1 Lorem ipsum dolor sit amet, consectetur adipiscing elit. ~ MARIA CAN"),
    MyMessage("Hola Jetpack Compose 2", "¿Preparado? 2 Consectetur adipiscing elit.Praesent consectetur ante enim. ~ MARIA CAN"),
    MyMessage("Hola Jetpack Compose 3", "¿Preparado? 3 Cras consequat, ante a varius accumsan, purus urna tempus tellus, et sollicitudin ex erat a turpis. In fermentum purus et nisi laoreet, vitae faucibus turpis posuere. Praesent non libero in diam cursus fringilla et a neque. Sed eget tellus urna. ~ MARIA CAN"),
    MyMessage("Hola Jetpack Compose 4", "¿Preparado? 4 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc malesuada et diam et placerat. Phasellus gravida et est id egestas. Convallis egestas arcu. ~ MARIA CAN"),
    MyMessage("Hola Jetpack Compose 5", "¿Preparado? 5 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc malesuada et diam et placerat. Phasellus gravida et est id egestas. Praesent consectetur ante enim.Nunc malesuada et diam et placerat. ~ MARIA CAN"),
    MyMessage("Hola Jetpack Compose 6", "¿Preparado? 6 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc malesuada et diam et placerat. Phasellus gravida et est id egestas. Praesent consectetur ante enim. Mauris porta nisl dapibus, sodales ligula a, sagittis eros. ~ MARIA CAN"),
    MyMessage("Hola Jetpack Compose 7", "¿Preparado? 7 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc malesuada et diam et placerat. Phasellus gravida et est id egestas. Praesent consectetur ante enim. Nulla a porttitor lacus. ~ MARIA CAN"),
    MyMessage("Hola Jetpack Compose 8", "¿Preparado? 8 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc malesuada et diam et placerat. Phasellus gravida et est id egestas. Praesent consectetur ante enim. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. ~ MARIA CAN"),
    MyMessage("Hola Jetpack Compose 9", "¿Preparado? 9 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc malesuada et diam et placerat. Phasellus gravida et est id egestas. Praesent consectetur ante enim. In fermentum purus et nisi laoreet, vitae faucibus turpis posuere. ~ MARIA CAN"),
    MyMessage("Hola Jetpack Compose 10", "¿Preparado? 10 Phasellus gravida et est id egestas. Praesent consectetur ante enim. ~MARIA CAN"),
    MyMessage("Hola Jetpack Compose 11", "¿Preparado? 11 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc malesuada et diam et placerat. Phasellus gravida et est id egestas. Praesent consectetur ante enim.In a leo at tortor feugiat lacinia. Nulla rhoncus aliquam neque, dui tempor eu. ~ MARIA CAN"),
    MyMessage("Hola Jetpack Compose 12", "¿Preparado? 12 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc malesuada et diam et placerat. Phasellus gravida et est id egestas. Praesent consectetur ante enim.Vivamus gravida blandit nunc non commodo. ~ MARIA CAN"),
    MyMessage("Hola Jetpack Compose 13", "¿Preparado? 13 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc malesuada et diam et placerat. Sed eget tellus urna.  ~ MARIA CAN"))

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
fun MyTexts(message: MyMessage){ //Para comprimir y descomprimir el text
    var expanded by remember{ mutableStateOf(false)}
    Column(modifier = Modifier.padding(start = 8.dp).clickable {
        expanded = !expanded
    }) {
        MyText(
            message.title,
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(16.dp)) //Separación entre columnas
        MyText(
            message.body,
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.subtitle2,
            if (expanded) Int.MAX_VALUE else 1
        )
    }
}

//Esto es un elemento gráfico
@Composable
fun MyText(text: String, color: Color, style: androidx.compose.ui.text.TextStyle, lines: Int = Int.MAX_VALUE){
    Text(text, color = color, style = style, maxLines = lines)
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