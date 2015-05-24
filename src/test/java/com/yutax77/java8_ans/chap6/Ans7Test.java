package com.yutax77.java8_ans.chap6;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class Ans7Test {
    @Test
    public void test() {
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        map.put("a", 0L);
        map.put("b", 10L);
        map.put("c", 100L);
        map.put("d", 1000L);
        map.put("e", 10000L);
        map.put("f", 100000L);
        map.put("g", 1000000L);
        map.put("h", 10000000L);
        map.put("i", 100000000L);
        map.put("j", 1000000000L);
        map.put("k", 10000000000L);
        map.put("l", 100000000000L);
        map.put("m", 1000000000000L);
        map.put("n", 10000000000000L);
        map.put("o", 100000000000000L);
        map.put("p", 1000000000000000L);
        map.put("q", 10000000000000000L);
        map.put("r", 100000000000000000L);
        map.put("r", 1000000000000000000L);

        assertThat(Ans7.findMaxValueKey(map), is("r"));
    }
}
