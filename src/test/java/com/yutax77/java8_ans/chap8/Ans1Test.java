package com.yutax77.java8_ans.chap8;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class Ans1Test {
    @Test
    public void testAdd() {
        int x = Integer.MAX_VALUE + 1;
        int y = Integer.MAX_VALUE + 2;
        long expResult = (Integer.MAX_VALUE * 2L) + 3L;
        long result = Ans1.add(x, y);
        assertThat(result, is(expResult));
    }

    @Test
    public void testSubstract() {
        int x = Integer.MAX_VALUE + 1;
        int y = Integer.MAX_VALUE + 2;
        long expResult = -1L;
        long result = Ans1.substract(x, y);
        assertThat(result, is(expResult));
    }

    @Test
    public void testDivide() {
        System.out.println("divide");
        int dividend = 0xffffffff;
        int divisor = 2;
        int expResult = 2147483647;
        int result = Ans1.divide(dividend, divisor);
        assertEquals(expResult, result);
    }

    @Test
    public void testDiff() {
        System.out.println("diff");
        int x = Integer.MAX_VALUE + 1;
        int y = Integer.MAX_VALUE + 10;
        int expResult = -1;
        int result = Ans1.diff(x, y);
        assertEquals(expResult, result);
    }
    
}
