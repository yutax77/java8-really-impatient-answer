package com.yutax77.java8_ans.chap2;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Ans8 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
	Iterator<T> firstIter = first.iterator();
	Iterator<T> secondIter = second.iterator();
	Iterator<T> zipIter = new Iterator<T>() {
	    boolean isFirst = true;
	    
	    @Override
	    public boolean hasNext() {
		if(isFirst) {
		    return firstIter.hasNext() && secondIter.hasNext();
		} else {
		    return secondIter.hasNext();
		}
	    }

	    @Override
	    public T next() {
		if(isFirst) {
		    isFirst = false;
		    return firstIter.next();
		}
		isFirst = true;
		return secondIter.next();
	    }
	    
	};
	
	return StreamSupport.stream(Spliterators.spliteratorUnknownSize(zipIter, Spliterator.ORDERED), false);
    }
}
