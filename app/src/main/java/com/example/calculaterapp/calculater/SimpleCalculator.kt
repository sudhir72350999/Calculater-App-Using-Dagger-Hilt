package com.example.basicprojectusingdaggerhilt.calculater

import javax.inject.Inject

//class SimpleCalculator @Inject constructor(): Calculator {
class SimpleCalculator : Calculator {


    override fun addition(a: Double, b: Double): Double =a+b


    override fun subtract(a: Double, b: Double): Double =a-b


    override fun multiply(a: Double, b: Double): Double =a*b

    override fun divide(a: Double, b: Double): Double {
        if (b == 0.0) throw IllegalArgumentException("Division by zero")
        return a / b
    }




}