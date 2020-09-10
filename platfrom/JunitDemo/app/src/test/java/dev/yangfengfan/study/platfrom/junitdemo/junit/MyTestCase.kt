package dev.yangfengfan.study.platfrom.junitdemo.junit

import junit.framework.TestCase
import org.junit.Ignore
import org.junit.Test

/**
 * @author yangfengfan 2020-09-10
 */
class MyTestCase : TestCase() {

    @Test //该方法默认会在主线程中执行
    fun test1() {
        println("test1")
    }

    @Test(timeout = 2000)  //该方法会在一个单独的线程中执行，单位为毫秒，这里超时时间为2秒, 实际运行时会超过2秒，测试无法通过
    fun test2() {
        println("test2")
    }


    @Ignore("Not ready")
    @Test
    fun test3() {
        println("test开头的方法不会被忽略")
    }

    @Ignore("Not Ready")
    @Test
    fun atest3() {
        println("非test开头的方法会被忽略")
    }

    // setUp()在每个@Test方法执行前都会执行一次
    override fun setUp() {
        super.setUp()
        println("setUp")
    }

    // set the name of the test case
    override fun setName(name: String?) {
        super.setName(name)
        println("setName")
    }

}