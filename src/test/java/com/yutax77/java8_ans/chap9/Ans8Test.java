package com.yutax77.java8_ans.chap9;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static com.yutax77.java8_ans.chap9.Ans8.Point;

import org.junit.Test;

public class Ans8Test {

    @Test
    public void testCompareTo() {
        Point a = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertThat(a.compareTo(a), is(0));
        assertThat(a.compareTo(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE)), is(-1));

        Point b = new Point(-10, -10);
        assertThat(a.compareTo(b), is(-1));
        
        assertThat(b.compareTo(a), is(1));
        assertThat(b.compareTo(new Point(-10, 0)), is(-1));
        assertThat(b.compareTo(new Point(-10, -20)), is(1));
        assertThat(b.compareTo(new Point(0, -10)), is(-1));
        assertThat(b.compareTo(new Point(-20, -10)), is(1));
    }

}
