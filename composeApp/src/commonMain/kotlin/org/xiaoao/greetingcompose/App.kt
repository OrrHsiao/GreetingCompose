package org.xiaoao.greetingcompose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import greetingcompose.composeapp.generated.resources.Res
import greetingcompose.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        RowView()
    }
}

/*默认示例*/
@Composable
@Preview
fun DemoView() {
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
    }
}

/*垂直排列*/
@Composable
@Preview
fun ColumnView() {
    Column(Modifier.background(Color.Yellow).fillMaxWidth()) {
        Text("text1", Modifier.fillMaxWidth().padding(5.dp).background(Color.LightGray))
        Text("text2", Modifier.fillMaxWidth().padding(5.dp).background(Color.LightGray))
    }
}

/*水平排列*/
@Composable
@Preview
fun RowView() {
    Row(modifier = Modifier.height(80.dp).fillMaxWidth().padding(5.dp).background(Color.Yellow)) {
        Image(
            painterResource(Res.drawable.compose_multiplatform),
            null,
            modifier = Modifier.fillMaxHeight().clip(
                CircleShape
            )
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "标题",
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.height(35.dp).fillMaxWidth().background(Color.Blue),
            )
            /*利用Box包裹来实现纵向居中*/
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier.height(35.dp).fillMaxWidth().background(Color.Red),
            ) {
                Text(
                    text = "内容",
                    fontSize = 10.sp,
                )
            }
        }
    }
}

/*堆叠*/
@Composable
@Preview
fun BoxView(content: String? = null) {
    Box(Modifier.background(Color.Blue)) {
        Text(content ?: "空", Modifier.fillMaxWidth().padding(5.dp).background(Color.LightGray))
    }
}