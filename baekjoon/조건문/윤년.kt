package com.example.baekjoon.조건문

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val token = StringTokenizer(readLine())
    val year = Integer.parseInt(token.nextToken())
    close()

    if (year%4 == 0) {
        if (year%100 != 0 || year%400 == 0) {
            println(1)
        }
        else
            println(0)
    }
    else
        println(0)
}