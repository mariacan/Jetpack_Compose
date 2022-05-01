package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
        //Se llama y también ponerlo en el PreviewTexts Para verlo
        MyComponent()
        }
    }
}
@Composable
fun MyComponent(){
    Row() {
        MyImage()
        MyTexts()
    }
}

//Add Image
@Composable//Sustetible 
fun MyImage(){
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        "My Image de prueba"
    )
}
//Mostrarlo de manera ordenada en una ccolumna (Uno debajo del otro)
@Composable
fun MyTexts(){
    Column() {
        MyText("¡Hola Jetpack Compose!")
        MyText("¿Preparado?")
    }
}

//Esto es un elemento gráfico
@Composable
fun MyText(text: String){
    Text(text)
}
//PREVIEW VISUALIZER
@Preview
@Composable
fun PreviewComponent (){
    MyComponent()
}