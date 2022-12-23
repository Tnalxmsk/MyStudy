package com.example.baekjoon.입출력

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val c = scanner.nextInt()

    val result1 = (a+b)%c
    val result2 = ((a%c) + (b%c))%c
    val result3 = (a*b)%c
    val result4 =  ((a%c) * (b%c))%c

    println(result1)
    println(result2)
    println(result3)
    println(result4)
}