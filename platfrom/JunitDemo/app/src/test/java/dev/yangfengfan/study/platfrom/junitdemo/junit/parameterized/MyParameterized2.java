package dev.yangfengfan.study.platfrom.junitdemo.junit.parameterized;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MyParameterized2 {

    @Parameterized.Parameters
    public static List getParams() {
        return Arrays.asList(new Integer[][]{
            {0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}, {6, 8}
        });
    }

    //这里必须是public，不能是private
    @Parameterized.Parameter
    public int input = 0;

    //注解括号里的参数，用来指定参数的顺序，默认为0
    @Parameterized.Parameter(1)
    public int expected = 0;

    @Test
    public void testFibonacci() {
        System.out.println(input + "," + expected);
        Assert.assertEquals(expected, Fibonacci.INSTANCE.getFibonacciValue(input));
    }

}