package com.yutax77.java8_ans.chap2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.junit.Test;

public class Ans2Test extends Chap2TestBase {
    @Test
    public void test() {
	AtomicInteger count = new AtomicInteger();
	List<String> actual = words.stream()
		.filter(w -> w.length() > 12)
		.peek(e -> count.incrementAndGet())
		.limit(5)
		.collect(Collectors.toList());

	assertThat(count.get(), is(5));
	assertThat(actual.size(), is(5));
    }
}
