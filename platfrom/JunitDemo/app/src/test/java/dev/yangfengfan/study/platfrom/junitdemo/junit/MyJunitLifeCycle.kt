package dev.yangfengfan.study.platfrom.junitdemo.junit

import org.junit.*

/**
 * @author yangfengfan 2020-09-10
 */
class MyJunitLifeCycle {

    @Test
    fun test() {
        println("test")
    }

    /**
     * must be [public void]
     *
     * 对应[@After],会在每个测试方法执行前都调用一次
     */
    @Before
    fun before() {
        println("before")
    }

    /**
     *  must be [public void]
     *
     * 对应[@Before],会在每个测试方法执行完后都调用一次
     */
    @After
    fun after() {
        println("after")
    }




    companion object {
        /**
         * must be [public static void]
         *
         * 对应[@AfterClass]会在所有的测试方法执行之前调用一次
         * <p> @Before在每个方法执行前都会调用一次，有多少个测试方法就会掉用多少次
         * <p> @BeforeClass只会执行一次，在所有的测试方法执行前调用一次
         */
        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            println("beforeClass")
        }

        /**
         * must be [public static void]
         *
         * 对应[@BeforeClass],会在所有的测试方法执行之前调用一次
         */
        @AfterClass
        @JvmStatic
        fun afterClass() {
            println("afterClass")
        }
    }
}