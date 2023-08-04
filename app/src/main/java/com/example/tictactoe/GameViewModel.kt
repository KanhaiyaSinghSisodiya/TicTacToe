package com.example.tictactoe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameViewModel: ViewModel() {

    var state by mutableStateOf(GameState())
        private set

    var boardItem: MutableMap<Int, BoardCellValue> by mutableStateOf(mutableMapOf(
        1 to BoardCellValue.NONE,
        2 to BoardCellValue.NONE,
        3 to BoardCellValue.NONE,
        4 to BoardCellValue.NONE,
        5 to BoardCellValue.NONE,
        6 to BoardCellValue.NONE,
        7 to BoardCellValue.NONE,
        8 to BoardCellValue.NONE,
        9 to BoardCellValue.NONE
    ))

    private var k =0;

    fun onAction(action: UserAction) {
        when(action) {
            is UserAction.PlayAgainButtonClicked -> {
                boardItem = mutableMapOf(
                    1 to BoardCellValue.NONE,
                    2 to BoardCellValue.NONE,
                    3 to BoardCellValue.NONE,
                    4 to BoardCellValue.NONE,
                    5 to BoardCellValue.NONE,
                    6 to BoardCellValue.NONE,
                    7 to BoardCellValue.NONE,
                    8 to BoardCellValue.NONE,
                    9 to BoardCellValue.NONE
                )
                var jk = ""
                if (state.currentTurn == BoardCellValue.CIRCLE) {
                    jk = "Player 'O' turn"
                }
                else {
                    jk = "Player 'X' turn"
                }

                state = state.copy(victoryType = VictoryType.NONE,
                    hasWon = false,

                    hintText = jk
                )
                k=0
            }
            is UserAction.BoardTapped ->
            {
                if(!state.hasWon) {
                    k++;
                    addValueToBoard(action.cellNumber)
                    if(hasWon()) {

                        state.hasWon = true
                        if(boardItem[action.cellNumber] == BoardCellValue.CROSS) {
                            state.playerCrossCount++
                            state.hintText = "Player 'X' won"
                        }
                        else if(boardItem[action.cellNumber] == BoardCellValue.CIRCLE) {
                            state.playerCircleCount++
                            state.hintText = "Player 'O' won"
                        }
                    }
                    else if(k==9)  {
                        state.drawCount++
                        state.hintText = "Draw"
                    }
                }
            }
        }
    }

    private fun hasWon(): Boolean {
        if(boardItem[1]==boardItem[2] && boardItem[3]==boardItem[1] && boardItem[1] != BoardCellValue.NONE) {
            state.victoryType = VictoryType.HORIZONTAL1
            return true
        }
        else if(boardItem[4]==boardItem[5] && boardItem[5]==boardItem[6] && boardItem[4] != BoardCellValue.NONE) {
            state.victoryType = VictoryType.HORIZONTAL2
            return true
        }
        else if(boardItem[7]==boardItem[8] && boardItem[8]==boardItem[9] && boardItem[9] != BoardCellValue.NONE) {
            state.victoryType = VictoryType.HORIZONTAL3
            return true
        }
        else if(boardItem[1]==boardItem[4] && boardItem[4]==boardItem[7] && boardItem[1] != BoardCellValue.NONE) {
            state.victoryType = VictoryType.VERTICAL1
            return true
        }
        else if(boardItem[2]==boardItem[5] && boardItem[5]==boardItem[8] && boardItem[2] != BoardCellValue.NONE) {
            state.victoryType = VictoryType.VERTICAL2
            return true
        }
        else if(boardItem[3]==boardItem[6] && boardItem[6]==boardItem[9] && boardItem[9] != BoardCellValue.NONE) {
            state.victoryType = VictoryType.VERTICAL3
            return true
        }
        else if(boardItem[1]==boardItem[5] && boardItem[5]==boardItem[9] && boardItem[1] != BoardCellValue.NONE) {
            state.victoryType = VictoryType.CROSS1
            return true
        }
        else if(boardItem[3]==boardItem[5] && boardItem[5]==boardItem[7] && boardItem[7] != BoardCellValue.NONE) {
            state.victoryType = VictoryType.CROSS2
            return true
        }
        return false
    }

    private fun addValueToBoard(cellNumber: Int) {
        if (boardItem[cellNumber] != BoardCellValue.NONE) {
            return
        }
        if (state.currentTurn == BoardCellValue.CIRCLE) {
            boardItem[cellNumber] = BoardCellValue.CIRCLE
            state = state.copy(
                hintText = "Player 'X' turn",
                currentTurn = BoardCellValue.CROSS
            )
        }
        else if(state.currentTurn == BoardCellValue.CROSS) {
            boardItem[cellNumber] = BoardCellValue.CROSS
            state = state.copy(
                hintText = "Player 'O' turn",
                currentTurn = BoardCellValue.CIRCLE
            )
        }
    }
}