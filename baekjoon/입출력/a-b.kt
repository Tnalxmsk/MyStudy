package com.example.baekjoon

import android.renderscript.ScriptGroup
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    var number1 = scanner.nextInt()
    var number2 = scanner.nextInt()
    var add = number1 + number2
    var min = number1 - number2
    var mul = number1 * number2
    var div = number1 / number2
    var r = number1 % number2
    println(add)
    println(min)
    println(mul)
    println(div)
    println(r)
}