package com.yutax77.java8_ans.chap2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class Ans5Test {

    @Test
    public void testGenerate() {
	Stream<Long> actual = Ans5.generate(25214903917L, 11L,
		(long) Math.pow(2, 48), 11);
	Set<Long> set = actual
			.limit(100)
			.peek(e -> System.out.println(e))
			.collect(Collectors.toSet());

	assertThat(set.size(), is(100));
    }

}
