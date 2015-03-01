package com.yutax77.java8_ans.chap1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Ans4Test {
    private File root;
    private File[] expected;
    
    @Before
    public void setUp() throws URISyntaxException {
	root = new File(getClass().getResource("file1").toURI()).getParentFile();
	
	expected = new File[]{
		new File(root, "subDir1"),
		new File(root, "subDir2"),
		new File(root, "subDir3.ext"),
		new File(root, "file1"),
		new File(root, "file1.ext"),
		new File(root, "file2.ext"),
		new File(root, "fileext"),
		new File(root, "subDir.ext"),
	};
    }
    
    @Test
    public void testSort() {
	List<File> orig = Arrays.asList(Arrays.copyOf(expected, expected.length));
	Collections.shuffle(orig);
	File[] shuffled = orig.toArray(new File[]{});
	assertThat(shuffled.length, is(expected.length));
	assertThat(shuffled, not(expected));
	
	Ans4.sort(shuffled);
	assertThat(shuffled, is(expected));
    }

}
