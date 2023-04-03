package Trees

fun sortedArrayToBST(nums: IntArray) : TreeNode? {
    if (nums.isEmpty()) return null

    // Calculate the middle index of the array
    val middleIndex = nums.size / 2

    // Create a new TreeNode with the middle value
    val root = TreeNode(nums[middleIndex])

    // Recursively create the left and right subtrees
    root.left = sortedArrayToBST(nums.sliceArray(0 until middleIndex))
    root.right = sortedArrayToBST(nums.sliceArray(middleIndex+1 until nums.size))

    return root
}
fun main() {
    val nums = intArrayOf(-10, -3, 0, 5, 9)
    val root = sortedArrayToBST(nums)
    printTree(root)
}
fun printTree(root: TreeNode?) {
    if (root == null) {
        return
    }
    printTree(root.left)
    print("${root.`val`} ")
    printTree(root.right)
}