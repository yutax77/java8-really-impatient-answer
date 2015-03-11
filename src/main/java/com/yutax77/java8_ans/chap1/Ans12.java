package com.yutax77.java8_ans.chap1;

import java.util.ArrayList;
import java.util.Collection;

public class Ans12 {
    
    /*
     * The following class has compile error.
     * 
     * [The return type is incompatible with Collection<String>.stream()
     * Ans12.java]
     */
    /*
    @SuppressWarnings("serial")
    static class Legacy extends ArrayList<String> {
	public Stream<String> stream() {
	    return new Stream<>();
	}
    }
    */
    
    static class Stream<T> {
	
    }
}
