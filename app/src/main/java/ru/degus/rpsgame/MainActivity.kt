package ru.degus.rpsgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewUp.text = "Please enter one of the following:" +
                " Rock, Paper, Scissors."

    }

    fun getGameChoice(optionsParam: Array<String>) = optionsParam[(Random.nextInt(0,optionsParam.size))]

    fun getUserChoice(optionsParam: Array<String>): String {
        var isValidChoice = false
        var userChoice = ""

        while (!isValidChoice) {

            val userInput = editText.text.toString()


            if (userInput != null && userInput in optionsParam) {
                isValidChoice = true
                userChoice = userInput
            }
            else textView.text = "You must enter a valid choice."
        }
        return userChoice
    }

    fun printResult(userChoice: String, gameChoice: String, optionsParam: Array<String>) {
        val result: String

        if (userChoice == gameChoice) result = "Tie!"
        else if ((userChoice == optionsParam[0] && gameChoice == optionsParam[2]) ||
            (userChoice == optionsParam[1] && gameChoice == optionsParam[0]) ||
            (userChoice == optionsParam[2] && gameChoice == optionsParam[1])) result = "You win!"
        else result = "You lose!"
        textView.text = result
    }

    fun onClick(view: View) {
        val options = arrayOf("Rock", "Paper", "Scissors")
        val gameChoice = getGameChoice(options)
        val userChoice = getUserChoice(options)
        printResult(userChoice, gameChoice, options)
    }
}
