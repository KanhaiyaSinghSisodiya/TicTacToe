package com.example.tictactoe

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tictactoe.ui.theme.Aqua
import com.example.tictactoe.ui.theme.GreenishYellow

@Composable
fun BoardBase() {
    Canvas(modifier = Modifier
        .size(300.dp)
        .padding(10.dp)
    ) {
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x=size.width/3,y= 0f),
            end = Offset(x =size.width/3, y=size.height)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x=size.width*2/3,y= 0f),
            end = Offset(x = size.width*2/3, y=size.height)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x=0f,y= size.height/3),
            end = Offset(x = size.width, y=size.height/3)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x=0f,y= size.height*2/3),
            end = Offset(x = size.width, y=size.height*2/3)
        )
    }
}

@Composable
fun Cross() {
    Canvas(modifier = Modifier
        .size(60.dp)
        .padding(5.dp)) {
        drawLine(
            color = GreenishYellow,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x=0f,y=0f),
            end = Offset(x=size.width,y = size.height)
        )
        drawLine(
            color = GreenishYellow,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            end = Offset(x=0f,y= size.height),
            start = Offset(x=size.width,y = 0f)
        )
    }
}

@Composable
fun Zero() {
    Canvas(modifier = Modifier
        .size(60.dp)
        .padding(5.dp)) {
        drawCircle(
            color = Aqua,
            style = Stroke(width = 20f)
        )
    }
}

@Composable
fun HorizontalWinLine1() {
    Canvas(modifier = Modifier.size(300.dp)){
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f,y=size.height/6),
            end = Offset(x=size.width, y = size.height/6)
        )
    }
}

@Composable
fun HorizontalWinLine2() {
    Canvas(modifier = Modifier.size(300.dp)){
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f,y=size.height/2),
            end = Offset(x=size.width, y = size.height/2)
        )
    }
}

@Composable
fun HorizontalWinLine3() {
    Canvas(modifier = Modifier.size(300.dp)){
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f,y=size.height*5/6),
            end = Offset(x=size.width, y = size.height*5/6)
        )
    }
}

@Composable
fun VerticalWinLine1() {
    Canvas(modifier = Modifier.size(300.dp)){
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width/6,y = 0f),
            end = Offset(x=size.width/6, y = size.height)
        )
    }
}

@Composable
fun VerticalWinLine2() {
    Canvas(modifier = Modifier.size(300.dp)){
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width/2,y = 0f),
            end = Offset(x=size.width/2, y = size.height)
        )
    }
}

@Composable
fun VerticalWinLine3() {
    Canvas(modifier = Modifier.size(300.dp)){
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*5/6,y = 0f),
            end = Offset(x=size.width*5/6, y = size.height)
        )
    }
}

@Composable
fun CrossWinLine1() {
    Canvas(modifier = Modifier.size(300.dp)){
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f,y = 0f),
            end = Offset(x=size.width, y = size.height)
        )
    }
}

@Composable
fun CrossWinLine2() {
    Canvas(modifier = Modifier.size(300.dp)){
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width,y = 0f),
            end = Offset(x=0f, y = size.height)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun or() {
    BoardBase()
    HorizontalWinLine1()
    HorizontalWinLine2()
    HorizontalWinLine3()
    VerticalWinLine1()
    VerticalWinLine2()
    VerticalWinLine3()
    CrossWinLine1()
    CrossWinLine2()
}