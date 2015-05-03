package com.yutax77.java8_ans.chap9;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.yutax77.java8_ans.chap9.Ans9_10.LabeledPoint;

public class Ans9_10Test {
    private LabeledPoint p1;
    private LabeledPoint p2;
    private LabeledPoint p3;
    
    @Before
    public void setUp() {
        p1 = new LabeledPoint("label1", 0, 0);
        p2 = new LabeledPoint("label2", 1, 1);
        p3 = new LabeledPoint("label1", 0, 0);
    }
    
    @Test
    public void testEqualAndHashCode() {
        assertThat(p1.equals(p1), is(true));
        assertThat(p2.equals(p2), is(true));
        assertThat(p1.equals(p3), is(true));
        assertThat(p1.equals(p2), is(false));

        assertThat(p1.hashCode(), is(p3.hashCode()));
        assertThat(p1.hashCode(), not(is(p2.hashCode())));
        assertThat(p2.hashCode(), not(is(p3.hashCode())));
    }
    
    @Test
    public void testCompareTo() {
        assertThat(p1.compareTo(p1), is(0));
        assertThat(p1.compareTo(p3), is(0));
        
        assertThat(p1.compareTo(p2), is(-1));
        assertThat(p2.compareTo(p1), is(1));
    }
}
