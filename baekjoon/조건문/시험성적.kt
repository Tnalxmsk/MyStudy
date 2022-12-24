package com.example.baekjoon.조건문

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val token = StringTokenizer(readLine())
    val number = Integer.parseInt(token.nextToken())
    close()

    when {
        number >= 90 -> println("A")
        number >= 80 -> println("B")
        number >= 70 -> println("C")
        number >= 60 -> println("D")
        else -> println("F")
    }
}