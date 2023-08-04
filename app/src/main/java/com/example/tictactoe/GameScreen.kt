package com.example.tictactoe

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictactoe.ui.theme.BlueCustom
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GameScreen(
    viewModel: GameViewModel = viewModel()
) {
    val state = viewModel.state
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 30.dp)
        .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
        ) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Player '0': "+state.playerCircleCount, fontSize = 16.sp)
            Text(text = "Draw: "+state.drawCount, fontSize = 16.sp)
            Text(text = "Player 'X': "+state.playerCrossCount, fontSize = 16.sp)
        }
        Text(text = "Tic Tac Toe", fontFamily = FontFamily.Cursive,
            fontSize = 50.sp, modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, color = BlueCustom)
        Box(modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1F)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(20.dp)
            )
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            BoardBase()
            LazyVerticalGrid(modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
                columns = GridCells.Fixed(3)) {
                viewModel.boardItem.forEach {
                    (cellNo, boardCellValue) -> item {
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .clickable {
                                viewModel.onAction(UserAction.BoardTapped(cellNo))
                            },
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            when(boardCellValue) {
                                 BoardCellValue.CIRCLE -> Zero()
                                 BoardCellValue.CROSS -> Cross()
                                 BoardCellValue.NONE -> {}
                            }
                        }
                    }
                }
            }
            when(state.victoryType) {
                VictoryType.HORIZONTAL1 -> HorizontalWinLine1()
                VictoryType.HORIZONTAL2 -> HorizontalWinLine2()
                VictoryType.HORIZONTAL3 -> HorizontalWinLine3()
                VictoryType.VERTICAL1 -> VerticalWinLine1()
                VictoryType.VERTICAL2 -> VerticalWinLine2()
                VictoryType.VERTICAL3 -> VerticalWinLine3()
                VictoryType.CROSS2 -> CrossWinLine2()
                VictoryType.CROSS1 -> CrossWinLine1()
                else -> {}
            }
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Text(text = state.hintText, fontSize = 24.sp, fontFamily = FontFamily.Cursive)
            Button(onClick = { viewModel.onAction(UserAction.PlayAgainButtonClicked) }, shape = RoundedCornerShape(5.dp),
                elevation = ButtonDefaults.buttonElevation(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = BlueCustom,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Play Again", fontSize = 16.sp)
            }
        }
    }
}
