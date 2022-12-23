package com.example.baekjoon

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    var king = scanner.nextInt()
    var queen = scanner.nextInt()
    var rook = scanner.nextInt()
    var bishop = scanner.nextInt()
    var night = scanner.nextInt()
    var pawn = scanner.nextInt()

    var changeKing: Int = 1 - king
    var changeQueen: Int = 1 - queen
    var changeRook: Int = 2 - rook
    var changeBishop: Int = 2 - bishop
    var changeNight: Int = 2 - night
    var changePawn: Int = 8 - pawn

    println("$changeKing $changeQueen $changeRook $changeBishop $changeNight $changePawn")
}