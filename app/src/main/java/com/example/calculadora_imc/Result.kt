package com.example.calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadora_imc.databinding.ActivityResultBinding

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bind = ActivityResultBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val imc = intent.getParcelableExtra<Imc>("imc")

        bind.textResultHeight.text = imc?.height.toString() + "m"
        bind.textResultWeight.text = imc?.weight.toString() + "Kg"
        bind.textResultName.text = imc?.name.toString()
        bind.textResultGenre.text = imc?.genre.toString()
        bind.textResultImc.text = imc?.calculateImc().toString()

    }
}