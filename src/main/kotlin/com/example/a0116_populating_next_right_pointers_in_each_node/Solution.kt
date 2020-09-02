package com.example.a0116_populating_next_right_pointers_in_each_node

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
        var levelStart = root
        while (levelStart != null) {
            var cur = levelStart
            while (cur != null) {
                if (cur.left != null) cur.left!!.next = cur.right
                if (cur.right != null && cur.next != null) cur.right!!.next = cur.next!!.left
                cur = cur.next
            }
            levelStart = levelStart.left
        }
        return root
    }
}
