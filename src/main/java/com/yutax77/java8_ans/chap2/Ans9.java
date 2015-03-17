package com.yutax77.java8_ans.chap2;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class Ans9 {
    public static <T> Optional<ArrayList<T>> reduce1(Stream<ArrayList<T>> src) {
	return src.reduce((x, y) -> {
	    x.addAll(y);
	    return x;
	});
    }

    public static <T> ArrayList<T> reduce2(Stream<ArrayList<T>> src) {
	return src.reduce(new ArrayList<>(),
	    (x, y) -> {
		x.addAll(y);
		return x;
	});
    }
    
    public static <T> ArrayList<T> reduce3(Stream<ArrayList<T>> src) {
	return src.reduce(new ArrayList<>(),
		(x, y) -> {
		    x.addAll(y);
		    return x;
		},
		(t1, t2) -> {
		    t1.addAll(t2);
		    return t1;
		});
    }
}
