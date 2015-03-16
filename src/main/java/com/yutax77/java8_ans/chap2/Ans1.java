package com.yutax77.java8_ans.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class Ans1 {
    public static long countLongWord(List<String> words) throws InterruptedException {
	int processors = Runtime.getRuntime().availableProcessors();
	
	List<List<String>> divided = divideList(words, processors);
	assert divided.size() == processors;
	
	AtomicLong count = new AtomicLong();
	List<Callable<Void>> tasks = new ArrayList<>();
	for(List<String> dividedWords: divided) {
	    Callable<Void> task = () -> {
		for(String word: dividedWords) {
		    if(word.length() > 12) {
			count.incrementAndGet();
		    }
		}
		return null;
	    };
	    tasks.add(task);
	}
	
	ExecutorService threadPool = Executors.newFixedThreadPool(processors);
	threadPool.invokeAll(tasks);
	threadPool.shutdownNow();
	
	return count.get();
    }
    
    static List<List<String>> divideList(List<String> words, int divideNum) {
	assert words != null && !words.isEmpty();
	assert divideNum > 0;
	
	List<List<String>> result = new ArrayList<>();
	int length = words.size();
	if(length < divideNum) {
	    //one by one
	    for(String word: words) {
		result.add(Arrays.asList(word));
	    }
	    return result;
	}
	
	int per = length / divideNum;
	int modula = length % divideNum;
	
	int fromIndex = 0;
	int toIndex = per;
	for(int i = 0; i < divideNum; i++){
	    result.add(new ArrayList<>(words.subList(fromIndex, toIndex)));
	    fromIndex += per;
	    toIndex += per;
	}
	
	if(modula != 0) {
	    //add remainder to last element
	    List<String> last = result.get(result.size() - 1);
	    last.addAll(new ArrayList<>(words.subList(words.size() - modula, words.size())));
	}
	
	return result;
    }
}
