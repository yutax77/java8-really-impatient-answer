package com.yutax77.java8_ans.chap2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class Ans10Test {

    @Test
    public void testAverage() {
	Stream<Double> stream = Stream.of(1.0, 2.0, 3.0);
	double actual = Ans10.average(stream);
	
	assertThat(actual, is(2.0));
    }

}
