package com.yutax77.java8_ans.chap2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class Ans2Test {
    private List<String> words;
    
    @Before
    public void setUp() throws IOException, URISyntaxException {
        String contents = new String(Files.readAllBytes(
        	Paths.get(getClass().getResource("alice.txt").toURI())),
        	StandardCharsets.UTF_8); // Read file into string
        words = Arrays.asList(contents.split("[\\P{L}]+"));
    }
    
    @Test
    public void test() {
	AtomicInteger count = new AtomicInteger();
	List<String> actual = words.stream()
		.filter(w -> w.length() > 12)
		.peek(e -> count.incrementAndGet())
		.limit(5)
		.collect(Collectors.toList());

	assertThat(count.get(), is(5));
	assertThat(actual.size(), is(5));
    }
}
