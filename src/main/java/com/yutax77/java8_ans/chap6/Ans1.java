package com.yutax77.java8_ans.chap6;

import java.util.concurrent.atomic.AtomicReference;

public class Ans1 {
    public static class LongStringCollector {
        private AtomicReference<String> longest;
        
        public LongStringCollector() {
            longest = new AtomicReference<>();
            longest.lazySet("");
        }
        
        public void check(String str) {
            longest.accumulateAndGet(str, (x, y) -> {
                if(x.length() >= y.length()){
                    return x;
                } else {
                    return y;
                }
            });
        }
        
        public String getLongest() {
            return longest.get();
        }
    }
}
