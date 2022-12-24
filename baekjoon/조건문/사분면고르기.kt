package com.example.baekjoon.조건문


import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val x = Integer.parseInt(readLine())
    val y = Integer.parseInt(readLine())
    close()
    when {
        x > 0 && y > 0 -> println(1)
        x < 0 && y > 0 -> println(2)
        x < 0 && y < 0 -> println(3)
        x > 0 && y < 0 -> println(4)
    }
}