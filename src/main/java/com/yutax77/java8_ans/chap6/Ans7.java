package com.yutax77.java8_ans.chap6;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Ans7 {
    public static String findMaxValueKey(ConcurrentHashMap<String, Long> map) {
        Entry<String, Long> entry = map.reduceEntries(0, (x, y) -> {
            int comp = x.getValue().compareTo(y.getValue());
            if (0 > comp) {
                return y;
            } else {
                return x;
            }
        });

        return entry.getKey();
    }
}
