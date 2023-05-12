package stack

import java.util.*

fun evalRPN(tokens: Array<String>): Int {
    val stack = Stack<Int>()
    for (token in tokens) {
        stack.push(
            if (token == "+" || token == "-" || token == "*" || token == "/") operationWithToken(token, stack)
            else token.toInt()
        )
    }
    return stack.pop()
}

fun operationWithToken(token: String, stack: Stack<Int>): Int? {
    val y = stack.pop()
    val x = stack.pop()
    if (token == "+") return x+y
    else if (token == "-") return x-y
    else if (token == "*") return x*y
    else return x/y
}
fun main() {
    val tokens = arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+")
    println(evalRPN(tokens))
}
