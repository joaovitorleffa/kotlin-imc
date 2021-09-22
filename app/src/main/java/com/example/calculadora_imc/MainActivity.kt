package com.example.calculadora_imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadora_imc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bind = ActivityMainBinding.inflate(layoutInflater);
        setContentView(bind.root)

        bind.buttonCalculate.setOnClickListener{
            val height = bind.inputHeight.text.toString()
            val weight = bind.inputWeight.text.toString()
            val name = bind.inputName.text.toString()
            val genre = bind.inputGenre.text.toString()

            if (height.isEmpty()) {
                Toast.makeText(this, "Informe a altura", Toast.LENGTH_LONG).show()
            } else if (weight.isEmpty()) {
                Toast.makeText(this, "Informe o peso", Toast.LENGTH_LONG).show()
            } else {
                val imc =  Imc(name, genre, height.toDouble(), weight.toDouble())
                val intent = Intent(this, Result::class.java)
                intent.putExtra("imc", imc)
                startActivity(intent)
            }
        }
    }
}