package com.example.tictactoe

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val WC = ViewGroup.LayoutParams.WRAP_CONTENT
    private val FP = ViewGroup.LayoutParams.WRAP_CONTENT

    private var gameBoard = Board()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initGameBoard()
        resetBtn.setOnClickListener { resetGame() }
    }

    private fun initGameBoard() {
        table_layout.isStretchAllColumns = true
        var counter = 1
        for (row in 0..2) {
            val tableRow = TableRow(this)
            for (col in 0..2) {
                val button = Button(this)
                button.tag = counter
                button.setOnClickListener(this)
                button.width = 300
                button.height = 300
                button.textSize = 40f
                tableRow.addView(button)
                counter++
            }
            table_layout.addView(tableRow, TableLayout.LayoutParams(FP, WC))
        }
    }

    override fun onClick(v: View) {
        val player1 = "X"
        val player2 = "O"
        var place = ""
        if (!gameBoard.gameOver) {
            when (gameBoard.currentPlayer) {
                1 -> place = player1
                2 -> place = player2
            }
            val choice = Integer.valueOf(v.tag.toString())
            gameBoard.placePiece(choice)
            (v as Button).text = place
            updateUI()
        }
    }

    private fun updateUI() {
        when (gameBoard.gameStatus) {
            1,2 -> resultTxt!!.text = "Player ${gameBoard.gameStatus} Wins!"
            0 -> resultTxt!!.text = getString(R.string.game_draw)
            else -> {
            }
        }
    }

    private fun resetGame() {
        table_layout.removeAllViews()
        resultTxt.text = " "
        initGameBoard()
        gameBoard = Board()
    }
}