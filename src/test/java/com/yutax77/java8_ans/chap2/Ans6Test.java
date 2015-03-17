package com.yutax77.java8_ans.chap2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class Ans6Test {

    @Test
    public void testCharacterStream() {
	String input = "Ans6 Method.";
	Stream<Character> actual = Ans6.characterStream(input);
	
	List<Character> asList = actual.collect(Collectors.toList());
	List<Character> expected = new ArrayList<>();
	for(char c: input.toCharArray()) {
	    expected.add(c);
	}
	
	assertThat(asList, is(expected));
    }

}
