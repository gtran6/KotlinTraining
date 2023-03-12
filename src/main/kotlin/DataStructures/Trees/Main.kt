package DataStructures.Trees

fun main() {
    val hot = TreeNode("hot")
    val cold = TreeNode("cold")
    val beverage = TreeNode("beverage").run {
        add(hot)
        add(cold)
    }
}