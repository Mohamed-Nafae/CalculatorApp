package com.benmeddour.calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var number: String = ""
    var number2: String = ""
    var opration: String = ""
    var n1 = true
    fun clickNumber(view: View) {
        val textView: TextView = findViewById(R.id.textView) as TextView
        val choisbtn = view as Button
        if (n1) {
            when (choisbtn.id) {
                R.id.button0 -> {
                    if (number == "" || number == "-") number = "0"
                    else if (number.toDouble() == 0.0) number = "0"
                    else number += "0"
                }
                R.id.button1 -> number += "1"
                R.id.button2 -> number += "2"
                R.id.button3 -> number += "3"
                R.id.button4 -> number += "4"
                R.id.button5 -> number += "5"
                R.id.button6 -> number += "6"
                R.id.button7 -> number += "7"
                R.id.button8 -> number += "8"
                R.id.button9 -> number += "9"
                R.id.button -> number += "."
                R.id.buttonmoinorplus -> {
                    if (number == "") {
                        number += "-"
                    } else if (number == "-") {
                        number = ""
                    } else {
                        if (number.contains('.')) {
                            var double: Double = number.toDouble()
                            double *= (-1)
                            number = double.toString()
                        } else {
                            var double: Double = number.toDouble()
                            double *= (-1)
                            number = double.toString()
                            number = number.substring(0, number.length - 2)
                        }
                    }
                }
            }
            if (number.get(0) == '0' && number.length > 1) {
                number = number.substring(1)
            }
            textView.text = number
        } else {
            when (choisbtn.id) {
                R.id.button0 -> {
                    if (number2 == "" || number2 == "-") number2 = "0"
                    else if (number2.toDouble() == 0.0) number2 = "0"
                    else number2 += "0"
                }
                R.id.button1 -> number2 += "1"
                R.id.button2 -> number2 += "2"
                R.id.button3 -> number2 += "3"
                R.id.button4 -> number2 += "4"
                R.id.button5 -> number2 += "5"
                R.id.button6 -> number2 += "6"
                R.id.button7 -> number2 += "7"
                R.id.button8 -> number2 += "8"
                R.id.button9 -> number2 += "9"
                R.id.button -> number2 += "."
                R.id.buttonmoinorplus -> {
                    if (number2 == "") {
                        number2 += "-"
                    } else if (number2 == "-") {
                        number2 = ""
                    } else {
                        if (number2.contains('.')) {
                            var double: Double = number2.toDouble()
                            double *= -1
                            number2 = double.toString()
                        } else {
                            var double: Double = number2.toDouble()
                            double *= -1
                            number2 = double.toString()
                            number2 = number2.substring(0, number.length - 2)
                        }
                    }
                }
            }
            if (number2.get(0) == '0' && number2.length > 1) {
                number2 = number2.substring(1)
            }
            textView.text = number2
        }
    }

    fun clickoperation(view: View) {
        val textView: TextView = findViewById(R.id.textView) as TextView
        val choisbtn = view as Button
        if (number2 == "") {
            n1 = false
            try {
                val nb = number.toDouble()
                when (choisbtn.id) {
                    R.id.buttondiv -> opration = "/"
                    R.id.buttonplus -> opration = "+"
                    R.id.buttonfois -> opration = "*"
                    R.id.buttonmoin -> opration = "-"
                    R.id.buttonperssontage -> {
                        number = (number.toDouble() / 100).toString()
                        if (number.get(number.length - 1) == '0' && number.get(number.length - 2) == '.') number =
                            number.substring(0, number.length - 2)
                        textView.text = number
                    }
                    R.id.buttonequale -> {
                        number = ""
                        n1 = true
                    }
                }

            } catch (ex: Exception) {
                textView.text = "Erreur"
                number = ""
                opration = ""
                n1 = true
            }
        } else {
            n1 = false
            try {
                val nb = number2.toDouble()
                when (opration) {
                    "/" -> {
                        if ((number2.toDouble()) != 0.0) {
                            number = (number.toDouble() / number2.toDouble()).toString()
                        } else {
                            textView.text = "Math Erreur"
                            number = ""
                            n1 = true
                        }
                    }
                    "*" -> number = (number.toDouble() * number2.toDouble()).toString()
                    "-" -> number = (number.toDouble() - number2.toDouble()).toString()
                    "+" -> number = (number.toDouble() + number2.toDouble()).toString()
                }
                number2 = ""
                if (number.get(number.length - 1) == '0' && number.get(number.length - 2) == '.') {
                    number = number.substring(0, number.length - 2)
                }
                textView.text = number

                when (choisbtn.id) {
                    R.id.buttondiv -> opration = "/"
                    R.id.buttonplus -> opration = "+"
                    R.id.buttonfois -> opration = "*"
                    R.id.buttonmoin -> opration = "-"
                    R.id.buttonperssontage -> {
                        number = (number.toDouble() / 100).toString()
                        if (number.get(number.length - 1) == '0' && number.get(number.length - 2) == '.') {
                            number = number.substring(0, number.length - 3)
                        }
                        textView.text = number
                    }
                    R.id.buttonequale -> clean()
                }
            } catch (ex: Exception) {
                textView.text = "Erreur"
                clean()
            }
        }
    }

    fun cleanCal(view: View) {
        val textView: TextView = findViewById(R.id.textView) as TextView
        clean()
        textView.text = "0"
    }

    fun clean() {
        number = ""
        number2 = ""
        opration = ""
        n1 = true
    }

}