package com.yutax77.java8_ans.chap2;

import java.util.stream.Stream;

public class Ans7 {
    public static <T> boolean isFinite(Stream<T> stream) {
	return stream.spliterator().estimateSize() != Long.MAX_VALUE;
    }
}
