package com.yutax77.java8_ans.chap2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class Ans9Test {
    private Stream<ArrayList<String>> src;
    private ArrayList<String> expected;
    
    @Before
    public void setUp() {
	List<ArrayList<String>> asList = new ArrayList<>();
	asList.add(new ArrayList<String>(Arrays.asList("a", "b", "c")));
	asList.add(new ArrayList<String>(Arrays.asList("1", "2", "3")));
	asList.add(new ArrayList<String>(Arrays.asList("A", "B", "C")));
	src = asList.stream();
	
	expected = new ArrayList<>(Arrays.asList("a", "b", "c", "1", "2", "3", "A", "B", "C"));
    }
    
    @Test
    public void testReduce1() {
	Optional<ArrayList<String>> actual = Ans9.reduce1(src);
	
	assertThat(actual.isPresent(), is(true));
	assertThat(actual.get(), is(expected));
    }
    
    @Test
    public void testReduce2() {
	ArrayList<String> actual = Ans9.reduce2(src);
	
	assertThat(actual, is(expected));
    }

    @Test
    public void testReduce3() {
	ArrayList<String> actual = Ans9.reduce3(src);
	
	assertThat(actual, is(expected));
    }

}
