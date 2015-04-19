package com.yutax77.java8_ans.chap3;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ans20 {
    public <T, U> List<U> map(List<T> list, Function<T, U> function) {
	return list.stream().map(function).collect(Collectors.toList());
    }
}
