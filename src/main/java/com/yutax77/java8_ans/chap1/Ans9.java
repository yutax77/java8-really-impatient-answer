package com.yutax77.java8_ans.chap1;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ans9 {
    public interface Collection2<T> extends Collection<T> {
	public default void forEachIf(Consumer<T> action, Predicate<T> filter) {
	    final Iterator<T> each = iterator();
	    while (each.hasNext()) {
		T element = each.next();
		if (filter.test(element)) {
		    action.accept(element);
		}
	    }
	}
    }
    
}
