package com.yutax77.java8_ans.chap2;

import java.util.stream.Stream;

public class Ans5 {
    public static Stream<Long> generate(long a, long c, long m, long seed) {
	return Stream.iterate(seed, x ->  (a * x + c) % m);
    }
}
