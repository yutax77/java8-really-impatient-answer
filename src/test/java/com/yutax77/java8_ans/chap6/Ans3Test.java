package com.yutax77.java8_ans.chap6;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yutax77.java8_ans.chap6.Ans3.AtomicLongCounter;
import com.yutax77.java8_ans.chap6.Ans3.LongAdderCounter;

public class Ans3Test {
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
    public void benchmark_LongAdder() throws InterruptedException {
        LongAdderCounter counter = new LongAdderCounter();
        List<Callable<Void>> tasks = new ArrayList<>();
        IntStream.range(0, 1000).forEach(i -> {
            tasks.add(() -> {
                IntStream.range(0, 100000).forEach(x -> counter.increment());
                return null;
            });
        });

        Instant start = Instant.now();
        threadPool.invokeAll(tasks);
        Instant end = Instant.now();
        System.out.println("LongAdderCounter:" + Duration.between(start, end).toMillis());

        assertThat(counter.get(), is(100000000L));
    }

    @Test
    public void benchmark_AtomicLong() throws InterruptedException {
        AtomicLongCounter counter = new AtomicLongCounter();
        List<Callable<Void>> tasks = new ArrayList<>();
        IntStream.range(0, 1000).forEach(i -> {
            tasks.add(() -> {
                IntStream.range(0, 100000).forEach(x -> counter.increment());
                return null;
            });
        });

        Instant start = Instant.now();
        threadPool.invokeAll(tasks);
        Instant end = Instant.now();
        System.out.println("AtomicLongCounter:" + Duration.between(start, end).toMillis());
        assertThat(counter.get(), is(100000000L));
    }
}
