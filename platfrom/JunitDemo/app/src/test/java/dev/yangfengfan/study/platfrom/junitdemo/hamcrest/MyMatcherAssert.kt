package dev.yangfengfan.study.platfrom.junitdemo.hamcrest

import dev.yangfengfan.study.platfrom.junitdemo.hamcrest.MyMatcherAssert.MyNameClassMatcher.Companion.startWithYang
import org.hamcrest.BaseMatcher
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

/**
 * @author yangfengfan 2020-09-10
 */
class MyMatcherAssert {

    @Test
    fun test() {
        val name = "yangfengfan"
        val nameClass = NameClass("yangfengfan")

        /**
         * @reason 测试说明, 可选
         * @actual 实际值
         * @matcher matcher匹配
         */
        assertThat("startsWith()", name, startsWith("yang"))
        assertThat("endsWith()", name, endsWith("fan"))
        assertThat("containsString()", name, containsString("feng"))
        assertThat("sameInstance()", name, sameInstance(name))

        // allOf() 匹配所有，短路，类似&&
        assertThat("allOf()", name, allOf(startsWith("yang"), endsWith("fan")))

        // endsWith() 匹配其中一个几个，短路，类似||
        assertThat("endsWith()", name, anyOf(startsWith("yang"), endsWith("123")))

        // not() 不匹配通过，匹配不通过，类似!
        assertThat("not()", name, not(startsWith("123")))

        // 自定义匹配规则
        assertThat("自定义匹配规则", name, startWithYang(nameClass))

    }


    /**
     * 自定义Matcher匹配规则
     */
    private class MyNameClassMatcher<I>(private val nameClass: I) : BaseMatcher<I>() {

        override fun describeTo(description: Description?) {
            // 匹配失败的描述
            description?.appendText("不符合自定义Matcher匹配规则")
        }

        /**
         * 重写matches实现自定义匹配规则
         *
         * 我们这里判断item是否为 NameClass, 并且startsWith("yang")
         */
        override fun matches(item: Any?): Boolean {
            if (nameClass !is NameClass) {
                return false
            }
            return nameClass.name.startsWith("yang")
        }


        companion object {
            fun <T> startWithYang(items: T): Matcher<T> = MyNameClassMatcher(items)
        }
    }

    data class NameClass(var name: String)
}