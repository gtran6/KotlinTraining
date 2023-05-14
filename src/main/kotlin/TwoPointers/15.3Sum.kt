package TwoPointers

fun threeSum1(nums: IntArray): List<List<Int>> {
    nums.sort()
    var res = HashSet<List<Int>>()

    for (i in nums.indices) {
        var left = i + 1
        var right = nums.size - 1

        while (left < right) {
            val triple = nums[i] + nums[left] + nums[right]

            if (triple < 0) left++
            else if (triple > 0) right--
            else res.add(listOf(nums[i], nums[left++], nums[right]))
        }
    }
    return res.toList()
}

fun threeSum3(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val n = nums.size
    nums.sort()

    for (i in 0 until n-2) {
        if (i > 0 && nums[i] == nums[i-1]) {
            continue // skip duplicate values
        }
        var left = i+1
        var right = n-1
        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]
            when {
                sum == 0 -> {
                    result.add(listOf(nums[i], nums[left], nums[right]))
                    // skip duplicate values
                    while (left < right && nums[left] == nums[left+1]) {
                        left++
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right--
                    }
                    left++
                    right--
                }
                sum < 0 -> left++
                else -> right--
            }
        }
    }
    return result
}

// hashmap
fun threeSum2(nums: IntArray): List<List<Int>> {
    val result: MutableList<List<Int>> = mutableListOf()
    if (nums.size < 3) {
        return result
    }
    nums.sort()
    val map: MutableMap<Int, Int> = HashMap()
    for (i in nums.indices) {
        map[nums[i]] = i
    }
    for (i in 0 until nums.size - 2) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }
        for (j in i + 1 until nums.size - 1) {
            if (j > i + 1 && nums[j] == nums[j - 1]) {
                continue
            }
            val complement = 0 - nums[i] - nums[j]
            if (map.containsKey(complement) && map[complement]!! > j) {
                result.add(listOf(nums[i], nums[j], complement))
            }
        }
    }
    return result
}

fun main() {
    val nums = intArrayOf(-1,0,1,2,-1,-4) // -4,-1,-1,0,1,2
    println(threeSum1(nums))
}