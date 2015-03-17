package com.yutax77.java8_ans.chap2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ans6 {
    public static Stream<Character> characterStream(String s) {
	return IntStream.range(0, s.length()).mapToObj(s::charAt);
    }
}
