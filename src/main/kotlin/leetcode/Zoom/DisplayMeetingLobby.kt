package leetcode.Zoom

import java.util.*
import kotlin.collections.ArrayList

class DisplayLobby(root: Node?) {

    var stack: Stack<Node> = Stack()

    fun pushAll(node1: Node?) {
        var node = node1
        while (node != null) {
            stack.push(node)
            node = node.leftChild
        }
    }

    fun hasNext() : Boolean {
        return !stack.isEmpty()
    }

    fun nextName() : String {
        val tmp = stack.pop()
        pushAll(tmp.rightChild)
        return tmp.`val`
    }

    fun nextPage() : Array<String> {
        val res = ArrayList<String>()
        for (i in 0..9) {
            if (hasNext())
                res.add(nextName())
            else
                break
        }
        return res.toTypedArray()
    }
    init {
        pushAll(root)
    }
}

fun main() {
    val bst = BinarySearchTree()
    val names = arrayOf("Jeanette", "Latasha", "Elvira", "Caryl", "Antoinette", "Cassie", "Charity", "Lyn", "Elia", "Anya", "Albert", "Cherlyn", "Lala", "Kandice", "Iliana")
    for (name in names) bst.insert(name)
    val display = DisplayLobby(bst.root)
    println(Arrays.toString(display.nextPage()))
    println(Arrays.toString(display.nextPage()))
    println(Arrays.toString(display.nextPage()))
}
