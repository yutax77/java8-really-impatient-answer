package com.yutax77.java8_ans.chap6;

import org.junit.Test;

import com.yutax77.java8_ans.chap2.Chap2TestBase;
import com.yutax77.java8_ans.chap6.Ans1.LongStringCollector;

public class Ans1Test extends Chap2TestBase {
    @Test
    public void test() {
        LongStringCollector collector = new LongStringCollector();
        words.parallelStream().forEach(collector::check);
        System.out.println(collector.getLongest());
    }
}
