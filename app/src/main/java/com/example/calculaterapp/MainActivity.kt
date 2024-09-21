package com.example.calculaterapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basicprojectusingdaggerhilt.calculater.Calculator
import com.example.calculaterapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var calculator: Calculator

    // Initialize binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up the binding object
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle button clicks with proper binding access
        binding.btnAdd.setOnClickListener {
            performOperation(calculator::addition)
        }

        binding.btnSubtract.setOnClickListener {
            performOperation(calculator::subtract)
        }

        binding.btnMultiply.setOnClickListener {
            performOperation(calculator::multiply)
        }

        binding.btnDivide.setOnClickListener {
            performOperation(calculator::divide)
        }
    }

    private fun performOperation(operation: (Double, Double) -> Double) {
        val num1 = binding.input1.text.toString().toDoubleOrNull()
        val num2 = binding.input2.text.toString().toDoubleOrNull()

        if (num1 != null && num2 != null) {
            val resultValue = operation(num1, num2)
            binding.result.text = resultValue.toString()
        } else {
            binding.result.text = "Invalid input"
        }
    }
}
