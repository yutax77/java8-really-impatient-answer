package com.yutax77.java8_ans.chap8;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static com.yutax77.java8_ans.chap8.Ans4.*;

import java.util.OptionalLong;
import java.util.Random;

import org.junit.Test;

public class Ans4Test {

    @Test
    public void test() {
        OptionalLong val = findMinSeed();
        System.out.println(val);
        
        long minVal = val.orElseThrow(AssertionError::new);
        Random r = new Random(minVal);
        double d = Double.NaN;
        for(int i = 0; i < 376050; i++) {
            d = r.nextDouble();
        }
        
        assertThat(d, is(0.0));
        
    }

    @Test
    public void testPrev() {
        long s = prev(prev(prev(0L)));
        
        System.out.println(s);
        s = s ^ mask;
        System.out.println(s);
        
        Random r = new Random(s);
        double d = Double.NaN;
        for(int i = 0; i < 2; i++) {
            d = r.nextDouble();
        }
        
        assertThat(d, is(0.0));
    }
}
