package com.example.baekjoon.조건문

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val A = nextInt()
    val B = nextInt()

    when {
        A > B -> println(">")
        A == B -> println("==")
        A < B -> println("<")
    }
}
