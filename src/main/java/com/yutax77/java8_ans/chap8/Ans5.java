package com.yutax77.java8_ans.chap8;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Ans5 {
    public static long countLongWord(List<String> words) {
        AtomicLong count = new AtomicLong();
        words.forEach(w -> {
            if (w.length() > 12) {
                count.incrementAndGet();
            }
        });

        return count.get();
    }
}
