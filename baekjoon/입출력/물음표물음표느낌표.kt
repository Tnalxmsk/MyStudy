package com.example.baekjoon

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    var userId = scanner.nextLine()
    var exId = userId
    if (userId == exId) {
        var reset = userId + "??!"
        println(reset)
    }
}