package dev.yangfengfan.study.platfrom.junitdemo.junit.parameterized

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * 我们常规的测试方法都是public void修饰的，不能带有任何输入参数。
 * 但是有时我们需要在测试方法里输入参数，甚至可能需要指定批量的参数，如果使用常规的模式，那就需要为每一种参数写一个测试方法，这显然不是我们所期望的。
 * 使用Parameterized这个test runner就能实现这个目的。
 */
@RunWith(Parameterized::class) // 指定test runner
//在构造函数里，指定了2个输入参数，JUnit会在迭代数据源params的时候，自动传入这2个参数。
//例如：当获取到数据源的第3条数据{2，1}时，input=2，expected=1
class MyParameterized(private val input: Int, private val expected: Int) {


    @Test
    fun testFibonacci() {
        println("$input,$expected")
        Assert.assertEquals(expected.toLong(), Fibonacci.getFibonacciValue(input).toLong())
    }

    companion object {
        /**
         * param 测试的数据, 必须是public static,且必须返回一个可迭代的数组或者集合
         */
        @get:Parameterized.Parameters
        @JvmStatic
        val params: List<*> = listOf(arrayOf(0, 0), arrayOf(1, 1), arrayOf(2, 1), arrayOf(3, 2), arrayOf(4, 3), arrayOf(5, 5), arrayOf(6, 8))
    }
}




