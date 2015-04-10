package com.yutax77.java8_ans.chap2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ans13 {
    public static Map<Integer, Long> shortWords(List<String> words) {
	return words.parallelStream()
		.filter(s -> s.length() < 12)
		.collect(Collectors.groupingBy(
				String::length,
				Collectors.counting()));
    }
}
