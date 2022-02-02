package com.example.app.util

class BaseCalculator {

    fun sum(x: Long, y: Long): Long {
        return x + y
    }

    fun min(x: Long, y: Long): Long {
        return when {
            x > y -> x - y
            else -> y - x
        }
    }

    fun mul(x: Long, y: Long): Long {
        return x * y
    }

    fun div(x: Long, y: Long): Long {
        return x / y
    }
}