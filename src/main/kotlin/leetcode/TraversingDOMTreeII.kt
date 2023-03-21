package leetcode

class TreeNode2(v : String) {
    var value = v // hole value of a node
    var next: TreeNode2? = null // hold a reference to the next node at the same level
    var children = ArrayList<TreeNode2>() // hold a list of child nodes
}

var prev: TreeNode2? = null // hold a reference to the previous node at the same level
var leftmost: TreeNode2? = null // hold a reference to the leftmost node of the current level

fun processChild(childNode: TreeNode2?) {
    // if we found at least 1 node on the new level set up its next pointer
    if (childNode != null) {
        if (prev != null) {
            prev!!.next = childNode
        } else {
            //If the prev reference is null, it means that the child node is the leftmost node
            // of the current level, so the leftmost reference is set to the child node.
            leftmost = childNode
        }
        // update the child node
        prev = childNode
    }
}
// traverse the tree in level order
fun traversingDomTree(root: TreeNode2?) : TreeNode2? {
    if (root == null) return root

    //The leftmost reference is initialized to the root node
    leftmost = root

    // variable to keep track of nodes on the current level
    var curr: TreeNode2?

    // traverse till last node
    while (leftmost != null) {
        // "prev" tracks the latest node on the "next" level
        // "curr" tracks the latest node on the current level
        prev = null
        curr = leftmost
        leftmost = null

        // Iterate on the nodes of current level like a linked list
        while (curr != null) {
            println(curr.value)

            // process all the children and update the prev
            // and leftmost pointers
            for (child in curr.children) {
                processChild(child)
            }

            // move onto the next node
            curr = curr.next
        }
    }
    return root
}
fun main() {
    // Driver Code

    var root = TreeNode2("body");
    (root.children).add(TreeNode2("div"));
    (root.children).add(TreeNode2("h1"));
    (root.children).add(TreeNode2("div"));
    (root.children.get(0).children).add(TreeNode2("h2"));
    (root.children.get(0).children.get(0).children).add(TreeNode2("ul"));
    (root.children.get(0).children).add(TreeNode2("h3"));
    (root.children.get(0).children.get(1).children).add(TreeNode2("a"));
    (root.children.get(0).children.get(1).children).add(TreeNode2("p"));
    (root.children.get(0).children.get(1).children).add(TreeNode2("table"));
    (root.children.get(2).children).add(TreeNode2("p"));
    (root.children.get(2).children).add(TreeNode2("a"));
    (root.children.get(2).children).add(TreeNode2("p"));

    traversingDomTree(root);
}
/*
Time complexity:
The time complexity of the algorithm is O(n) where n is the number of nodes in the tree. This is because every
node is visited once in the worst case scenario, and there are n nodes in a tree.

Space complexity:
The space complexity of the algorithm is O(m) where m is the maximum number of nodes at any given level. This is
because we are traversing the tree level by level, and at any given time we need to keep track of the nodes at
the current level. Since the maximum number of nodes in a level can be m, the space complexity of the algorithm
is O(m). The space complexity is not O(n) because we only need to keep track of nodes at the current level, not all the nodes in the tree.
 */