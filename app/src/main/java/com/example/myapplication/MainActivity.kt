package com.example.calculator

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnadd.setOnClickListener {
            validate("+")
        }
        binding.btnSubstract.setOnClickListener {
            validate("-")
        }
        binding.btnMultiply.setOnClickListener {
            validate("*")
        }
        binding.btnDivide.setOnClickListener {
            validate("/")
        }

    }
    fun validate(symbol:String){
        val etNum1 = binding.etNum1.text.toString()
        val etNum2 = binding.etNum2.text.toString()
        var inputError= false
        if(etNum1.isBlank()){
            inputError= true
            binding.etNum1.error = "number2 is requires"
        }
        if (!inputError){
            calculate(etNum1.toDouble(),etNum2.toDouble(),symbol)
        }
    }
    fun calculate(num1:Double,num2:Double,symbol: String){
        var result = 0.0
        when(symbol){
            "+" -> result = num1+ num2
            "-" -> result = num1 - num2
            "*" -> result = num1*num2
            "/" -> result = num1/num2
        }
        binding.tvResult.text=result.toString()
    }


}