package com.yutax77.java8_ans.chap1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

public class Ans2Test {
    private File root;
    private File[] expected;
    
    @Before
    public void setUp() throws URISyntaxException {
	root = new File(getClass().getResource("file1").toURI()).getParentFile();
	
	expected = new File[]{
		new File(root, "subDir1"),
		new File(root, "subDir2"),
		new File(root, "subDir3.ext")
	};
    }
    
    @Test
    public void testSubDirs() {
	File[] actual = Ans2.getSubDirs(root);
	
	assertThat(actual, is(expected));
    }

    @Test
    public void testSubDirsByLambda() {
	File[] actual = Ans2.getSubDirsByLambda(root);
	
	assertThat(actual, is(expected));
    }
    
    @Test
    public void testSubDirsByLambda2() {
	File[] actual = Ans2.getSubDirsByLambda2(root);
	
	assertThat(actual, is(expected));
    }
}
