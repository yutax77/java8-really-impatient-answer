package com.yutax77.java8_ans.chap2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ans4 {
    public static void intStream() {
	int[] values = {1, 4, 9, 16};
	Stream<int[]> intArrayStream = Stream.of(values);
	
	IntStream intStream = IntStream.of(1, 4, 9, 16);
    }
}
