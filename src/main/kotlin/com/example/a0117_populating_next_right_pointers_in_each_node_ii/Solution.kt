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
        if (root == null) {
            return null
        }
        val next = help(root)
        connect(next)
        return root
    }

    private fun help(root: Node?): Node? {
        if (root == null) {
            return null
        }
        return if (root.left == null && root.right == null) {
            help(root.next)
        } else if (root.left == null) {
            root.right!!.next = help(root.next)
            root.right
        } else if (root.right == null) {
            root.left!!.next = help(root.next)
            root.left
        } else {
            root.left!!.next = root.right
            root.right!!.next = help(root.next)
            root.left
        }
    }
}
