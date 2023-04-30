package com.example.myapplication

fun main() {
    val list: LinkedList<Int> = LinkedList()

    list.addFirstNode(1)
    list.addLast(3)
    list.addLast(4)
    list.addLast(7)
    list.addNode(2, 1)

    list.printLinkedList()
}