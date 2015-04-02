package com.yutax77.java8_ans.chap2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;

public class Chap2TestBase {
    protected List<String> words;
    
    @Before
    public void setUp() throws IOException, URISyntaxException {
        String contents = new String(Files.readAllBytes(
        	Paths.get(getClass().getResource("alice.txt").toURI())),
        	StandardCharsets.UTF_8); // Read file into string
        words = Arrays.asList(contents.split("[\\P{L}]+"));
    }
}
