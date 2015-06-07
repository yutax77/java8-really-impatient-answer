package com.yutax77.java8_ans.chap8;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static java.util.Comparator.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Ans7Test {

    @Test
    public void test() {
        List<String> list = Arrays.asList("a", "b", null, "x", "y", null, "z");
        Collections.shuffle(list);
        
        Collections.sort(list, nullsLast(reverseOrder()));
        List<String> expected = Arrays.asList("z", "y", "x", "b", "a", null, null);
        assertThat(list, is(expected));
    }

}
