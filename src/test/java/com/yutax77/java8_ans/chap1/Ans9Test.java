package com.yutax77.java8_ans.chap1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.yutax77.java8_ans.chap1.Ans9.Collection2;

public class Ans9Test {

    @Test
    public void test() {
	Collection2Impl<String> collection = new Collection2Impl<>();
	collection.addAll(Arrays.asList("you", "i", "java", "me"));
	
	List<String> longStrings = new ArrayList<>();
	collection.forEachIf((str) -> longStrings.add(str), (str) -> (str.length() > 2));
	
	assertThat(longStrings, is(Arrays.asList("you", "java")));
	
    }

    static class Collection2Impl<T> extends ArrayList<T> implements Collection2<T> {
	/**
	 * Auto generated serialVersionUID.
	 */
	private static final long serialVersionUID = 7203429868755329903L;
    }
}
