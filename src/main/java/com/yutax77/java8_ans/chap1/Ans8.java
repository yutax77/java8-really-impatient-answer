package com.yutax77.java8_ans.chap1;

import java.util.ArrayList;
import java.util.List;

public class Ans8 {
    public static List<Runnable> captureWithExtendedLoop() {
	String[] names = { "Peter", "Paul", "Mary" }; 
	List<Runnable> runners = new ArrayList<>();
	for (String name : names) {
	    runners.add(() -> System.out.println(name));
	}
	
	return runners;
    }
    
    /*
     * The following method has compile error.
     * Because local variable *i* isn't final nor effectively final.
     */
    /*
    public static List<Runnable> captureWithTraditionalLoop() {
	String[] names = { "Peter", "Paul", "Mary" }; 
	List<Runnable> runners = new ArrayList<>();
	for (int i = 0; i < names.length; i++) {
	    runners.add(() -> System.out.println(names[i]));
	}
	
	return runners;
    }
    */
}
