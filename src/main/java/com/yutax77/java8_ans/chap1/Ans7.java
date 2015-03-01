package com.yutax77.java8_ans.chap1;

public class Ans7 {
    public static Runnable andThen(Runnable first, Runnable second) {
	return () -> {
	    first.run();
	    second.run();
	};
    }
}
