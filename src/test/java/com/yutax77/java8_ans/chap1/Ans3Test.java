package com.yutax77.java8_ans.chap1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

public class Ans3Test {
    private File root;
    private File[] expected;
    
    @Before
    public void setUp() throws URISyntaxException {
	root = new File(getClass().getResource("file1").toURI()).getParentFile();
	
	expected = new File[]{
		new File(root, "file1.ext"),
		new File(root, "file2.ext"),
		new File(root, "subDir.ext")
	};
    }
    
    @Test
    public void testGetFilesByExt() {
	File[] actual = Ans3.getFilesByExt(root, "ext");
	assertThat(actual, is(expected));
    }

}
