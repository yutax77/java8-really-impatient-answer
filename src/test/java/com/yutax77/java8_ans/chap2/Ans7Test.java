package com.yutax77.java8_ans.chap2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class Ans7Test {

    @Test
    public void testIsFinite_limited() {
	Stream<String> limited = Stream.of("A", "B", "C");
	assertThat(Ans7.isFinite(limited), is(true));
	
	//Stream has already been closed!
	//limited.forEach(System.out::println);
    }
    
    @Test
    public void testIsFinite_unlimited() {
	Stream<String> unlimited = Stream.generate(() -> "hoge");
	assertThat(Ans7.isFinite(unlimited), is(false));
	
	//Stream has already been closed!
	//limited.forEach(System.out::println);
    }

}
