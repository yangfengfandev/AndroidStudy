package dev.yangfengfan.study.platfrom.junitdemo.junit.rules

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 * @author yangfengfan 2020-09-10
 */
class RepeatRule : TestRule {

    //这里定义一个注解，用于动态在测试方法里指定重复次数
    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.FUNCTION)
    annotation class Repeat(val count: Int)

    override fun apply(base: Statement, description: Description): Statement? {
        return object : Statement() {
            override fun evaluate() {
                val repeat = description.getAnnotation(Repeat::class.java)
                //如果有@Repeat注解，则会重复执行指定次数
                if (repeat != null) {
                    for (i in 0 until repeat.count) {
                        base.evaluate()
                    }
                } else {
                    //如果没有注解，则不会重复执行
                    base.evaluate()
                }
            }
        }
    }


}
