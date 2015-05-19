package com.yutax77.java8_ans.chap6;

import java.util.concurrent.atomic.LongAccumulator;

public class Ans4 {
    public static class MaxAndMinAccumulator {
        private final LongAccumulator max;
        private final LongAccumulator min;
        
        public MaxAndMinAccumulator() {
            max = new LongAccumulator(Math::max, 0L);
            min = new LongAccumulator(Math::min, 0L);
        }
        
        public void accumulate(long value) {
            max.accumulate(value);
            min.accumulate(value);
        }
        
        public long getMax() {
            return max.get();
        }
        
        public long getMin() {
            return min.get();
        }
    }
}
