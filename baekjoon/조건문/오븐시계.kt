package com.example.baekjoon.조건문

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val token = StringTokenizer(readLine())
    var hour = Integer.parseInt(token.nextToken())
    var minuet = Integer.parseInt(token.nextToken())
    val waitingTime = readLine().toInt()
    close()
    val sum = minuet + waitingTime
    if (sum >= 60){
        val upNumber : Int = sum/60
        hour += upNumber
        minuet = sum%60
        if (hour >= 24){
            hour -= 24
        }
    }
    if (sum < 60){
        minuet = sum
    }
    println("$hour $minuet")
}