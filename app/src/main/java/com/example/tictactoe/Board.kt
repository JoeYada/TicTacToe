package com.example.tictactoe

class Board {
    var gameBoardArr = Array(3) { IntArray(3) }
    private var playCounter = 1
    @JvmField
    var gameOver = false
    @JvmField
    var gameStatus = 4

    fun placePiece(position: Int) {
        if (!gameOver) {
            var score = 0
            when (currentPlayer) {
                1 -> score = 1
                2 -> score = 5
            }
            when (position) {
                1 -> gameBoardArr[0][0] = score
                2 -> gameBoardArr[0][1] = score
                3 -> gameBoardArr[0][2] = score
                4 -> gameBoardArr[1][0] = score
                5 -> gameBoardArr[1][1] = score
                6 -> gameBoardArr[1][2] = score
                7 -> gameBoardArr[2][0] = score
                8 -> gameBoardArr[2][1] = score
                9 -> gameBoardArr[2][2] = score
                else -> {
                }
            }
            playCounter++
            gameStatus = gameResult
            if (gameStatus != GAME_NOT_OVER) {
                gameOver = true
            }
        }
    }

    val currentPlayer: Int
        get() {
            return if (playCounter % 2 == 0) 2 else 1
        }


    //check for draw
    val gameResult: Int
        get() {
            var hasZero = false
            var gameResult = 4
            var rowSum: Int
            var columnSum: Int

            //Test Row
            for (i in 0..2) {
                rowSum = gameBoardArr[i][0] + gameBoardArr[i][1] + gameBoardArr[i][2]
                if (rowSum == 15) {
                    gameResult = GAME_RESULT_P2_WIN
                    return gameResult
                } else if (rowSum == 3) {
                    gameResult = GAME_RESULT_P1_WIN
                    return gameResult
                }
            }

            //Test Column
            for (i in 0..2) {
                columnSum = gameBoardArr[0][i] + gameBoardArr[1][i] + gameBoardArr[2][i]
                if (columnSum == 15) {
                    gameResult = GAME_RESULT_P2_WIN
                    return gameResult
                } else if (columnSum == 3) {
                    gameResult = GAME_RESULT_P1_WIN
                    return gameResult
                }
            }

            //test diagonalSum
            val diagonalSum: Int = gameBoardArr[0][0] + gameBoardArr[1][1] + gameBoardArr[2][2]
            val anotherDiagonalSum: Int = gameBoardArr[2][0] + gameBoardArr[1][1] + gameBoardArr[0][2]
            if (diagonalSum == 3 || anotherDiagonalSum == 3) {
                gameResult = GAME_RESULT_P1_WIN
                return gameResult
            } else if (diagonalSum == 15 || anotherDiagonalSum == 15) {
                gameResult = GAME_RESULT_P2_WIN
                return gameResult
            }

            //check for draw
            for (i in 0..2) {
                for (j in 0..2) {
                    if (gameBoardArr[i][j] == 0) {
                        hasZero = true
                        break
                    }
                }
            }
            if (!hasZero) {
                gameResult = GAME_RESULT_DRAW
                return gameResult
            }
            return gameResult
        }

    companion object {
        const val GAME_RESULT_P1_WIN = 1
        const val GAME_RESULT_P2_WIN = 2
        const val GAME_RESULT_DRAW = 0
        const val GAME_NOT_OVER = 4
    }
}