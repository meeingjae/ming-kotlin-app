package com.example.app.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BaseCalculatorTest {

    private val calc: BaseCalculator = BaseCalculator()

    @Test
    fun sum() {

        val firstNum = 1L
        val secondNum = 2L
        assertEquals(3, calc.sum(firstNum, secondNum))
    }

    @Test
    fun min() {

        val firstNum = 1L
        val secondNum = 2L
        assertEquals(1, calc.min(firstNum, secondNum))
    }

    @Test
    fun mul() {

        val firstNum = 2L
        val secondNum = 5L
        assertEquals(10, calc.mul(firstNum, secondNum))
    }

    @Test
    fun div() {

        val firstNum = 10L
        val secondNum = 2L
        assertEquals(5, calc.div(firstNum, secondNum))
    }
}