package com.yutax77.java8_ans.chap2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Ans3Test {
    private List<String> words;
    
    @Before
    public void setUp() throws IOException, URISyntaxException {
        String contents = new String(Files.readAllBytes(
        	Paths.get(getClass().getResource("alice.txt").toURI())),
        	StandardCharsets.UTF_8); // Read file into string
        words = Arrays.asList(contents.split("[\\P{L}]+"));
    }
    
    @Test
    public void benchStream() throws IOException, URISyntaxException {
	long start = System.nanoTime();
	long count = words.stream().filter(w -> w.length() > 12).count();
	long end = System.nanoTime();
	
	assertThat(count, is(33L));
	
	System.out.println("Stream:" + (end - start) / 1000000  + " ms");
    }
    
    @Test
    public void benchParallelStream() throws IOException, URISyntaxException {
	long start = System.nanoTime();
	long count = words.parallelStream().filter(w -> w.length() > 12).count();
	long end = System.nanoTime();
	
	assertThat(count, is(33L));
	
	System.out.println("ParallelStream:" + (end - start) / 1000000 + " ms");
    }
}
