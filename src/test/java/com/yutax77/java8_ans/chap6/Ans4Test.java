package com.yutax77.java8_ans.chap6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yutax77.java8_ans.chap6.Ans4.MaxAndMinAccumulator;

public class Ans4Test {
    private ExecutorService threadPool;

    @Before
    public void setUp() {
        threadPool = Executors.newFixedThreadPool(1000);
    }

    @After
    public void tearDown() {
        threadPool.shutdownNow();
    }
    
    @Test
    public void test() throws InterruptedException {
        MaxAndMinAccumulator accumulator = new MaxAndMinAccumulator();
        List<Callable<Void>> tasks = new ArrayList<>();
        for(int i = 0; i < 1000; i++) {
            tasks.add(() -> {
                Random random = new Random();
                random.longs(10000, 0, 10000).forEach(accumulator::accumulate);
                return null;
            });
            
        }
        
        threadPool.invokeAll(tasks);
        
        System.out.println("Max:" + accumulator.getMax());
        System.out.println("Min:" + accumulator.getMin());
    }

}
