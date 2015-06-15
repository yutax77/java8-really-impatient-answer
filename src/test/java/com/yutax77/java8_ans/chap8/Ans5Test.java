package com.yutax77.java8_ans.chap8;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;

import org.junit.Test;

import com.yutax77.java8_ans.chap2.Chap2TestBase;

public class Ans5Test extends Chap2TestBase {
    @Test
    public void test() {
        Instant start = Instant.now();
        IntStream.range(0, 10000).forEach(i -> Ans5.countLongWord(words));
        Instant end = Instant.now();
        
        System.out.println("forEach:" + Duration.between(start, end).toMillis());
    }
    
    @Test
    public void testCountLongWordByStream() {
        Instant start = Instant.now();
        IntStream.range(0, 10000).forEach(i -> Ans5.countLongWordByStream(words));
        Instant end = Instant.now();
        
        System.out.println("stream:" + Duration.between(start, end).toMillis());
    }

    @Test
    public void testCountLongWordByParallelStream() {
        Instant start = Instant.now();
        IntStream.range(0, 10000).forEach(i -> Ans5.countLongWordByParallrelStream(words));
        Instant end = Instant.now();
        
        System.out.println("parallelStream:" + Duration.between(start, end).toMillis());
    }
}
