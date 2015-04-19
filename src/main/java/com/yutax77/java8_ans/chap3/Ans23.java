package com.yutax77.java8_ans.chap3;

import java.util.function.Function;

public class Ans23 {
    public static class Pair<T> {
	T p1;
	T p2;
	
	public Pair(T p1, T p2) {
	    this.p1 = p1;
	    this.p2 = p2;
	}
	
	public <U> Pair<U> map(Function<? super T, ? extends U> mapper) {
	    return new Pair<>(mapper.apply(p1), mapper.apply(p2));
	}
    }
}
