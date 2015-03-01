package com.yutax77.java8_ans.chap1;

import java.io.File;
import java.util.Arrays;

public class Ans4 {
    public static void sort(File[] orig) {
	Arrays.sort(orig, 0, orig.length, (first, second) -> {
	    if(first.isDirectory()) {
		if(second.isFile()) return -1;
		else return first.compareTo(second);
	    }
	    else if(first.isFile()) {
		if(second.isDirectory()) return 1;
		else return first.compareTo(second);
	    }
	    else return first.compareTo(second);
	});
    }
}
