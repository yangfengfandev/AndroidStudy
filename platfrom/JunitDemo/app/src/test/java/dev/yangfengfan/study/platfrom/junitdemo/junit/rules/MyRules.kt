package dev.yangfengfan.study.platfrom.junitdemo.junit.rules

import org.junit.Rule
import org.junit.Test

/**
 * @author yangfengfan 2020-09-10
 */
class MyRules {

    @Rule
    @JvmField
    val repeatRule: RepeatRule = RepeatRule()

    @RepeatRule.Repeat(count = 5) //自定义rules,重复执行三次
    @Test
    fun test1() {
        println("test1")
    }

}