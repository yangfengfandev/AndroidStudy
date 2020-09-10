package dev.yangfengfan.study.platfrom.junitdemo.junit.parameterized

object Fibonacci {
    // 菲波那切函数
    fun getFibonacciValue(n: Int): Int {
        return if (n <= 1) {
            n
        } else {
            getFibonacciValue(n - 1) + getFibonacciValue(n - 2)
        }
    }
}