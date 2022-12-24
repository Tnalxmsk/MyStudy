package com.example.baekjoon.조건문

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val token = StringTokenizer(readLine())
    val hour = Integer.parseInt(token.nextToken())
    val minuet = Integer.parseInt(token.nextToken())
    close()

    var changeHour : Int = hour
    var changeMinuet : Int = minuet - 45

    if (changeMinuet < 0){
        changeMinuet += 60
        changeHour -= 1
        if (changeHour == -1)
            changeHour = 23
    }

    println("$changeHour $changeMinuet" )
}