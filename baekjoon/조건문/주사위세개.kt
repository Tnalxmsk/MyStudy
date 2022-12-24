package com.example.baekjoon.조건문

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val token = StringTokenizer(readLine())
    val a = Integer.parseInt(token.nextToken())
    val b = Integer.parseInt(token.nextToken())
    val c = Integer.parseInt(token.nextToken())
    close()
    var result : Int? = null
    if (a == b && b == c){
        result = 10000 + a*1000
    }
    else if (a == b || b == c || a == c) {
        if (a == b) {
            result = 1000 + a*100
        }
        if ( b == c) {
            result = 1000 + b*100
        }
        if (a == c) {
            result = 1000 + a*100
        }
    }
    else if (a != b && b != c && a != c) {
        val numberList = listOf(a,b,c)
        var maxValue = numberList[0]
        for (i in numberList.indices) {
            if (maxValue < numberList[i]) {
                maxValue = numberList[i]
            }
        }
        result = 100*maxValue
    }
    println(result)
}