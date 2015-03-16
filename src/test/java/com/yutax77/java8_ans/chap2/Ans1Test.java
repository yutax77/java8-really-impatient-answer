package com.yutax77.java8_ans.chap2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class Ans1Test {
    private List<String> words;
    
    @Before
    public void setUp() throws IOException, URISyntaxException {
        String contents = new String(Files.readAllBytes(
        	Paths.get(getClass().getResource("alice.txt").toURI())),
        	StandardCharsets.UTF_8); // Read file into string
        words = Arrays.asList(contents.split("[\\P{L}]+"));
    }
        
    @Test
    public void testCountLongWord() throws InterruptedException {
	long start = System.nanoTime();
	long actual = Ans1.countLongWord(words);
	long end = System.nanoTime();

	assertThat(actual, is(33L));
	System.out.println("Parallel roop:" + (end - start) / 1000000  + " ms");
    }

    @DataPoints
    public static Fixture[] fixtures = new Fixture[]{
	new Fixture().length(1).divideNum(1).expected(new int[]{1}),
	new Fixture().length(1).divideNum(2).expected(new int[]{1}),
	
	new Fixture().length(2).divideNum(1).expected(new int[]{2}),
	new Fixture().length(2).divideNum(2).expected(new int[]{1, 1}),
	new Fixture().length(2).divideNum(3).expected(new int[]{1, 1}),
	
	new Fixture().length(5).divideNum(1).expected(new int[]{5}),
	new Fixture().length(5).divideNum(2).expected(new int[]{2, 3}),
	new Fixture().length(5).divideNum(3).expected(new int[]{1, 1, 3}),
	new Fixture().length(5).divideNum(4).expected(new int[]{1, 1, 1, 2}),
	new Fixture().length(5).divideNum(5).expected(new int[]{1, 1, 1, 1, 1}),
	
	new Fixture().length(6).divideNum(1).expected(new int[]{6}),
	new Fixture().length(6).divideNum(2).expected(new int[]{3, 3}),
	new Fixture().length(6).divideNum(3).expected(new int[]{2, 2, 2}),
	new Fixture().length(6).divideNum(4).expected(new int[]{1, 1, 1, 3}),
	new Fixture().length(6).divideNum(5).expected(new int[]{1, 1, 1, 1, 2}),
	new Fixture().length(6).divideNum(6).expected(new int[]{1, 1, 1, 1, 1, 1}),
    };
    
    @Theory
    public void testDivideList(Fixture fixture) {
	List<String> target = fixture.createList();
	
	List<List<String>> actual = Ans1.divideList(target, fixture.divideNum);
	
	assertThat(actual.size(), is(fixture.expected.length));
	for(int i = 0; i < actual.size(); i++) {
	    assertThat(actual.get(i).size(), is(fixture.expected[i]));
	}
	
    }
    
    static class Fixture {
	int length;
	int divideNum;
	int[] expected;
	
	Fixture length(int length) {
	    this.length = length;
	    return this;
	}
	
	Fixture divideNum(int divideNum) {
	    this.divideNum = divideNum;
	    return this;
	}
	
	Fixture expected(int[] expected) {
	    this.expected = expected;
	    return this;
	}
	
	List<String> createList() {
	    List<String> result = new ArrayList<>();
	    for(int i = 0; i < length; i++) {
		result.add(String.valueOf(i));
	    }
	    return result;
	}
    }
}
