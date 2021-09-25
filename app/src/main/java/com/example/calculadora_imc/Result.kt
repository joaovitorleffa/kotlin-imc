package com.example.calculadora_imc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadora_imc.databinding.ActivityResultBinding
import java.math.RoundingMode
import java.text.DecimalFormat

class Result : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityResultBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val person = intent.getParcelableExtra<Person>("imc")

        val df = DecimalFormat("#.##")

        val imcResult = person!!.calculateImc()
        val sex = person.sex.toString()

        val resultText = getCondition(imcResult, sex)

        bind.textResultHeight.text = person.height.toString() + "m"
        bind.textResultWeight.text = person.weight.toString() + "Kg"
        bind.textResultName.text = person.name.toString()
        bind.textResultSex.text = sex
        bind.textResultImc.text = df.format(imcResult).toString()
        bind.textResult.text = resultText

    }

    private fun getCondition(imc: Double, sex: String): String {
        return when (sex) {
            getString(R.string.male) -> {
                getMaleCondition(imc)
            }
            getString(R.string.female) -> {
                getFemaleCondition(imc)
            }
            else -> {
                getString(R.string.condition_not_found)
            }
        }
    }

    private fun getMaleCondition(imc: Double): String {
        return when {
            imc < 20.7 -> {
                getString(R.string.under_weight)
            }
            imc < 26.4 -> {
                getString(R.string.normal_weight)
            }
            imc < 27.8 -> {
                getString(R.string.marginally_overweight)
            }
            imc < 31.1 -> {
                getString(R.string.over_weight)
            } else -> {
                getString(R.string.obesidy)
            }
        }
    }

    private fun getFemaleCondition(imc: Double): String {
        return when {
            imc < 19.1 -> {
                getString(R.string.under_weight)
            }
            imc < 25.8 -> {
                getString(R.string.normal_weight)
            }
            imc < 27.3 -> {
                getString(R.string.marginally_overweight)
            }
            imc < 32.3 -> {
                getString(R.string.over_weight)
            } else -> {
                getString(R.string.obesidy)
            }
        }
    }
}