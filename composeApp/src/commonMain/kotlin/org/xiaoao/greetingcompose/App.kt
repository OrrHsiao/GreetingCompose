package org.xiaoao.greetingcompose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import greetingcompose.composeapp.generated.resources.Res
import greetingcompose.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            Text("hello!", Modifier.padding(horizontal = 10.dp, vertical = 10.dp).background(Color.Red))
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
            ColumnView()
            BoxView()
        }
    }
}

@Composable
@Preview
fun ColumnView() {
    Column(Modifier.background(Color.Yellow).fillMaxWidth()) {
        Text("text1", Modifier.fillMaxWidth().padding(5.dp).background(Color.LightGray))
        Text("text2", Modifier.fillMaxWidth().padding(5.dp).background(Color.LightGray))
    }
}

@Composable
@Preview
fun BoxView() {
    Box(Modifier.background(Color.Blue)) {
        Text("text3", Modifier.fillMaxWidth().padding(5.dp).background(Color.LightGray))
        Text("text4", Modifier.fillMaxWidth().padding(5.dp).background(Color.LightGray))
    }
}