package com.yutax77.java8_ans.chap8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.stream.Stream;

public class Ans12 {
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TestCase {
        int params();
        int expected();
    }
    
    @TestCase(expected = 2, params = 1)
    public static int plusOne(int x) {
        return x + 1;
    }
    
    @TestCase(expected = 0, params = 1)
    public static int minusOne(int x) {
        return x - 1;
    }
    
    public static void execTest(Class<?> target) {
        Stream.of(target.getMethods()).forEach(m -> {
            TestCase testCase = m.getAnnotation(TestCase.class);
            if(testCase == null) {
                return;
            }
            
            try {
                int actual = (int)m.invoke(target, testCase.params());
                if (actual == testCase.expected()) {
                    System.out.println(String.format("OK:%s@param=%d", m.getName(), testCase.params()));
                } else {
                    System.out.println(String.format("NG:%s@param=%d. Expected(%d) but actual(%d)", m.getName(), testCase.params(), testCase.expected(), actual));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
