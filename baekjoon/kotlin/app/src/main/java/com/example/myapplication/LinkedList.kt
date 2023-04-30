package com.example.myapplication

import java.lang.IndexOutOfBoundsException


class LinkedList<T> {
    private var headNode: Node<T>? = null
    private var _currentSize: Int = 0

    fun addFirstNode(data: T) {
        val newNode = Node(data, headNode)
        headNode = newNode
        _currentSize++
    }

    fun addLast(data: T) {
        val newNode = Node(data, null)
        var tmp = headNode
        // headNode 가 비어 있는 경우
        if (headNode == null) {
            headNode = newNode
            _currentSize++
        }
        // tmp 가 null 일 수 없음
        while (tmp?.next != null) {
            tmp = tmp.next
        }
        tmp?.next = newNode
        _currentSize++
    }

    private fun findData(index: Int): Node<T>? {
        var currentNode = headNode
        repeat(index) {
            currentNode = currentNode?.next
        }
        return currentNode
    }

    fun addNode(data: T, index: Int = _currentSize) {
        if (index > _currentSize)
            throw IndexOutOfBoundsException("out of index")
        var preNode: Node<T>? = null
        val nextNode: Node<T>? = findData(index)

        if (index != 0)
            preNode = findData(index - 1)

        when {
            // 이전 노드가 없으면 삽입 -> index = 0
            preNode == null -> addFirstNode(data)
            // 다음 노드가 없으면 -> index = current size
            nextNode == null -> addLast(data)
            // 이전 / 다음 노드 둘 다 있으면 -? 0 < index < current size
            else -> {
                val newNode = Node(data, nextNode)
                preNode.next = newNode
                _currentSize++
            }
        }
    }

    fun printLinkedList() {
        var currentNode = headNode

        while (currentNode != null) {
            println(currentNode.data)
            currentNode = currentNode.next
        }
    }

}