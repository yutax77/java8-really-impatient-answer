package com.yutax77.java8_ans.chap2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

public class Ans3Test extends Chap2TestBase {
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
