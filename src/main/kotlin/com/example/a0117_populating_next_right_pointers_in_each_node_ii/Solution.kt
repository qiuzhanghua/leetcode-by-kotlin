package com.example.a0117_populating_next_right_pointers_in_each_node_ii

/**
 * Definition for a Node.
 * */
class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

class Solution {
    fun connect(root: Node?): Node? {
        val ans = root
        var root: Node? = root
        val dummyHead = Node(0)
        var pre: Node = dummyHead
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left
                pre = pre.next!!
            }
            if (root.right != null) {
                pre.next = root.right
                pre = pre.next!!
            }
            root = root.next
            if (root == null) {
                pre = dummyHead
                root = dummyHead.next
                dummyHead.next = null
            }
        }
        return ans
    }
}
