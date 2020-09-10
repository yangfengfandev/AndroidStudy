package dev.yangfengfan.study.platfrom.junitdemo.junit

import org.junit.Assert.*
import org.junit.Test

/**
 * @author yangfengfan 2020-09-10
 */
class MyAssert {

    @Test
    fun test() {

        /**
         * @message 自定义错误信息
         * @expected 期望值
         * @actual 实际值
         *
         * 如果 [@expected] 和 [@actual] 相等测试通过，否则抛 AssertionError，可在[@message]中自定义异常信息
         */
        assertEquals("not equals", 4, 2 + 2)

        assertNotEquals("error", 5, 2 + 2)


        // 判断数组是否相等
        assertArrayEquals("array not equals", arrayOf(1, 2), arrayOf(1, 2))


        // 两个引用是否指向同一个对象
        val tempClass = TempClass()
        assertSame("class is same", tempClass, tempClass)

        assertNotSame("class not same", TempClass(), TempClass())

        // 判空
        assertNull("object not null", null)

        assertNotNull("object null", 1)

        assertTrue("false", true)

        assertFalse("true", false)
    }

    private class TempClass {}
}