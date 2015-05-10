package com.yutax77.java8_ans.chap6;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Ans3 {
    public static class LongAdderCounter {
        private final LongAdder counter = new LongAdder();

        public void increment() {
            counter.increment();
        }

        public long get() {
            return counter.longValue();
        }
    }

    public static class AtomicLongCounter {
        private final AtomicLong counter = new AtomicLong();

        public void increment() {
            counter.incrementAndGet();
        }

        public long get() {
            return counter.longValue();
        }
    }
}
