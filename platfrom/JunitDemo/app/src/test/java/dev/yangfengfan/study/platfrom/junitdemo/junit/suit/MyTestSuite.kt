package dev.yangfengfan.study.platfrom.junitdemo.junit.suit

import org.junit.runner.RunWith
import org.junit.runners.Suite


/**
 * Suite可以把一批测试类放到一块执行，可以用来同时测试多个类
 * Suite还可以进行嵌套，一个Suite里包含另外一个Suite
 *
 * @author yangfengfan 2020-09-10
 */

// @RunWith 选定一个特定的Runner来执行测试用例，所有的单元测试方法都是通过Runner来执行的
@RunWith(Suite::class)
@Suite.SuiteClasses(Suit1::class, Suit2::class)
class MyTestSuite {
//    testSuit1
//    testSuit2
}

@RunWith(Suite::class)
@Suite.SuiteClasses(Suit3::class)
class MyTestSuite1 {
//    testSuit3
}

@RunWith(Suite::class)
@Suite.SuiteClasses(MyTestSuite::class, MyTestSuite1::class)
class MyTestSuite2 {
//    testSuit1
//    testSuit2
//    testSuit3
}

