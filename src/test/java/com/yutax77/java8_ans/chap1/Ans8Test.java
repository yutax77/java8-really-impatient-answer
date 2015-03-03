package com.yutax77.java8_ans.chap1;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Ans8Test {
    private ExecutorService threadPool;
    
    @Before
    public void setUp() {
	threadPool = Executors.newFixedThreadPool(1);
	
    }
    
    @After
    public void tearDown() {
	threadPool.shutdownNow();
    }
    
    @Test
    public void testCaptureWithExtendedLoop() throws InterruptedException {
	List<Runnable> runners = Ans8.captureWithExtendedLoop();
	for(Runnable task: runners) {
	    threadPool.execute(task);
	}
	
	threadPool.awaitTermination(3, TimeUnit.SECONDS);
    }
}
