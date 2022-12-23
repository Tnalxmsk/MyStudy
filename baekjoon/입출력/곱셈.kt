package com.example.baekjoon.입출력

import java.io.BufferedReader
import java.io.InputStreamReader

fun main()  = with(BufferedReader(InputStreamReader(System.`in`))) {

    val a = readLine().toInt()
    val b = readLine().toInt()

    println(a*(b%10))
    println(a*((b%100)/10))
    println(a*(b/100))
    println(a*b)
}