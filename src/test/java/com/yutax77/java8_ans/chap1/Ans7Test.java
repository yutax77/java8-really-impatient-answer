package com.yutax77.java8_ans.chap1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Ans7Test {
    private AtomicInteger integer;
    private ExecutorService threadPool;
    
    @Before
    public void setUp() {
	integer = new AtomicInteger();
	threadPool = Executors.newFixedThreadPool(1);
    }
    
    @After
    public void tearDown() {
	threadPool.shutdownNow();
    }
    
    @Test
    public void testAndThen() throws InterruptedException, ExecutionException {
	Runnable first = new Runnable() {
	    @Override
	    public void run() {
		integer.compareAndSet(0, 10);
	    }
	};
	
	Runnable second = new Runnable() {
	    @Override
	    public void run() {
		integer.compareAndSet(10, 100);
	    }
	};
	
	Runnable andThen = Ans7.andThen(first, second);
	Future<?> feature = threadPool.submit(andThen);
	feature.get();
	
	assertThat(integer.get(), is(100));
    }

}
