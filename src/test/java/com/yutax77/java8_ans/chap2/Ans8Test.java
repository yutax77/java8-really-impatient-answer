package com.yutax77.java8_ans.chap2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class Ans8Test {

    @DataPoints
    public static Fixture[] fixtures = new Fixture[] {
	new Fixture().first("A", "B", "C").second("1", "2", "3").expected("A", "1", "B", "2", "C", "3"),
	new Fixture().first("A", "B").second("1", "2", "3").expected("A", "1", "B", "2"),
	new Fixture().first("A", "B", "C").second("1", "2").expected("A", "1", "B", "2"),
	
    };
    
    @Theory
    public void testZip(Fixture fixture) {
	Stream<String> actual = Ans8.zip(
					fixture.first.stream(),
					fixture.second.stream());
	List<String> asList = actual.collect(Collectors.toList());
	assertThat(asList, is(fixture.expected));
    }

    static class Fixture {
	List<String> first;
	List<String> second;
	List<String> expected;
	
	Fixture first(String... element) {
	    first = Arrays.asList(element);
	    return this;
	}
	
	Fixture second(String... element) {
	    second = Arrays.asList(element);
	    return this;
	}
	
	Fixture expected(String... element) {
	    expected = Arrays.asList(element);
	    return this;
	}
    }
}
