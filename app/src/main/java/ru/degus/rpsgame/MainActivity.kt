package ru.degus.rpsgame

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageEnemy.setImageResource(R.drawable.tie)
        imageEnemyChoice.setImageResource(R.drawable.question)
    }

    fun getGameChoice(optionsParam: Array<String>): String {
        val choice = optionsParam[(Random.nextInt(0,optionsParam.size))]
        when (choice) {
            "Rock" -> imageEnemyChoice.setImageResource(R.drawable.rock_enemy)
            "Paper" -> imageEnemyChoice.setImageResource(R.drawable.paper_enemy)
            "Scissors" -> imageEnemyChoice.setImageResource(R.drawable.scissors_enemy)
        }
        return choice
    }

    fun printResult(userChoice: String, gameChoice: String, optionsParam: Array<String>) {
        val result: String

        if (userChoice == gameChoice) {
            result = "Tie!"
            imageEnemy.setImageResource(R.drawable.tie)
        }
        else if ((userChoice == optionsParam[0] && gameChoice == optionsParam[2]) ||
            (userChoice == optionsParam[1] && gameChoice == optionsParam[0]) ||
            (userChoice == optionsParam[2] && gameChoice == optionsParam[1])) {
            result = "You win!"
            imageEnemy.setImageResource(R.drawable.win)
        }
        else {
            result = "You lose!"
            imageEnemy.setImageResource(R.drawable.lose)
        }
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Coaster.otf"))
        textView.text = result

    }

    fun onClikPaper(view: View) {
        val options = arrayOf("Rock", "Paper", "Scissors")
        val gameChoice = getGameChoice(options)
        val userChoice = "Paper"
        printResult(userChoice, gameChoice, options)
    }

    fun onClickRock(view: View) {
        val options = arrayOf("Rock", "Paper", "Scissors")
        val gameChoice = getGameChoice(options)
        val userChoice = "Rock"
        printResult(userChoice, gameChoice, options)
    }

    fun onClickScissors(view: View) {
        val options = arrayOf("Rock", "Paper", "Scissors")
        val gameChoice = getGameChoice(options)
        val userChoice = "Scissors"
        printResult(userChoice, gameChoice, options)
    }
}
