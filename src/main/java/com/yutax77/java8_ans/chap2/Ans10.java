package com.yutax77.java8_ans.chap2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Ans10 {
    public static double average(Stream<Double> stream) {
	AtomicInteger count = new AtomicInteger();
	Double sum = stream.reduce(0.0, (a, b) -> {
	    count.incrementAndGet();
	    return Double.sum(a, b);
	    });
	
	return sum.doubleValue() / count.get();
    }
}
