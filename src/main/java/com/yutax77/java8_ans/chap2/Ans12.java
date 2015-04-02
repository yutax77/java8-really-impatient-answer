package com.yutax77.java8_ans.chap2;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Ans12 {
    public static AtomicInteger[] shortWords(List<String> words) {
	AtomicInteger[] shortWords = Stream.generate(AtomicInteger::new)
		.limit(12).toArray(AtomicInteger[]::new);

	words.parallelStream().forEach(s -> {
	    if (s.length() < 12)
		shortWords[s.length()].incrementAndGet();
	});
	
	return shortWords;
    }
}
