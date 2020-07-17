package com.venegasdev.calculadorasimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSum = findViewById<Button>(R.id.btnSum)
        val btnSubstraction = findViewById<Button>(R.id.btnSubstraction)
        val btnMultiplication = findViewById<Button>(R.id.btnMultiplication)
        val btnDivision = findViewById<Button>(R.id.btnDivision)

        btnSum.setOnClickListener(View.OnClickListener {
            operation(Operations.SUM)
        })

        btnSubstraction.setOnClickListener(View.OnClickListener {
            operation(Operations.SUBSTRACTION)
        })

        btnMultiplication.setOnClickListener(View.OnClickListener {
            operation(Operations.MULTIPLICATION)
        })

        btnDivision.setOnClickListener(View.OnClickListener {
            operation(Operations.DIVISION)
        })
    }

    fun operation(type: Operations){
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val tnFirstNumber = findViewById<EditText>(R.id.tnFirstNumber)
        val tnSecondNumber = findViewById<EditText>(R.id.tnSecondNumber)

        if(tnFirstNumber.text.isNullOrEmpty()) {
            Toast.makeText(this, "Ingresa el primer número", Toast.LENGTH_SHORT).show()
            return
        }

        if(tnSecondNumber.text.isNullOrEmpty()) {
            Toast.makeText(this, "Ingresa el segundo número", Toast.LENGTH_SHORT).show()
            return
        }

        var firstNumber: Double = tnFirstNumber.text.toString().toDouble()
        var secondNumber: Double = tnSecondNumber.text.toString().toDouble()

        var result: Double = 0.0

        when(type){
            Operations.SUM -> result = firstNumber + secondNumber
            Operations.SUBSTRACTION -> result = firstNumber - secondNumber
            Operations.MULTIPLICATION -> result = firstNumber * secondNumber
            Operations.DIVISION -> {
                if(secondNumber == 0.0){
                    Toast.makeText(this, "Resultado: Infinito", Toast.LENGTH_SHORT).show()
                } else {
                    result = firstNumber / secondNumber
                }
            }
        }

        tvResult.setText(result.toString())
    }

    enum class Operations{
        SUM, SUBSTRACTION, MULTIPLICATION, DIVISION
    }
}