package com.example.tictactoe

import org.junit.Assert.assertTrue
import org.junit.Test

class BoardTest {

    var board = Board()

    @Test
    fun firstTurn_currentPlayer_returnsFirstPlayer() {
        assertTrue(board.currentPlayer == 1)
    }

    @Test
    fun placePiece_currentPlayer_returnsSecondPlayer() {
        board.placePiece(0)
        assertTrue(board.currentPlayer == 2)
    }

    @Test
    fun playersPlacePiece_p1WinsVertically() {
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(7) // p1
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(8) // p2
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(4) // p1
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(5) // p2
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(1) // p1
        assertTrue(board.gameResult == Board.GAME_RESULT_P1_WIN)
    }

    @Test
    fun playersPlacePiece_p1WinsHorizontally() {
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(1) // p1
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(4) // p2
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(2) // p1
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(5) // p2
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(3) // p1
        assertTrue(board.gameResult == Board.GAME_RESULT_P1_WIN)
    }

    @Test
    fun playersPlacePiece_p2WinsVertically() {
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(1) // p1
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(4) // p2
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(2) // p1
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(5) // p2
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(7) // p1
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(6) // p2
        assertTrue(board.gameResult == Board.GAME_RESULT_P2_WIN)
    }

    @Test
    fun playersPlacePiece_p1WinsDiagonal() {
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(1) // p1
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(4) // p2
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(5) // p1
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(8) // p2
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(9) // p1
        assertTrue(board.gameResult == Board.GAME_RESULT_P1_WIN)
    }

    @Test
    fun playersPlacePiece_p2WinsDiagonal() {
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(4) // p1
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(3) // p2
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(6) // p1
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(5) // p2
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(8) // p1
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(7) // p2
        assertTrue(board.gameResult == Board.GAME_RESULT_P2_WIN)
    }

    @Test
    fun playersPlacePiece_draw() {
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(9) // p1
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(8) // p2
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(4) // p1
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(1) // p2
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(7) // p1
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(3) // p2
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(5) // p1
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(6) // p2
        assertTrue(board.gameResult == Board.GAME_NOT_OVER)
        board.placePiece(2) // p1
        assertTrue(board.gameResult == Board.GAME_RESULT_DRAW)
    }
}