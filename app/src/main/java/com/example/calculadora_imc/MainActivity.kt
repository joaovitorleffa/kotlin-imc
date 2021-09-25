package com.example.calculadora_imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadora_imc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.buttonCalculate.setOnClickListener{
            val height = bind.inputHeight.text.toString()
            val weight = bind.inputWeight.text.toString()
            val name = bind.inputName.text.toString()
            val sex = bind.inputSex.text.toString()

            when {
                name.isEmpty() -> {
                    Toast.makeText(this, getString(R.string.fill_name), Toast.LENGTH_LONG).show()
                }
                sex.isEmpty() -> {
                    Toast.makeText(this, getString(R.string.fill_sex), Toast.LENGTH_LONG).show()
                }
                sex != getString(R.string.male) && sex != getString(R.string.female) -> {
                    Toast.makeText(this, getString(R.string.invalid_sex), Toast.LENGTH_LONG).show()
                }
                height.isEmpty() -> {
                    Toast.makeText(this, getString(R.string.fill_height), Toast.LENGTH_LONG).show()
                }
                weight.isEmpty() -> {
                    Toast.makeText(this, getString(R.string.fill_weight), Toast.LENGTH_LONG).show()
                }
                else -> {
                    val imc =  Person(name, sex, height.toDouble(), weight.toDouble())
                    val intent = Intent(this, Result::class.java)
                    intent.putExtra("imc", imc)
                    startActivity(intent)
                }
            }
        }
    }
}