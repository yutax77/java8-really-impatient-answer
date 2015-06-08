package com.yutax77.java8_ans.chap8;

import java.util.OptionalLong;
import java.util.stream.Stream;

public class Ans4 {

    private static final long a = 11L;
    private static final long v = 246154705703781L;
    static long N = (long) Math.pow(2, 48) - 1;
    static long mask = 25214903917L;

    public static OptionalLong findMinSeed() {
        return Stream.iterate(prev(0), Ans4::prev).mapToLong(s -> s ^ mask)
                .limit(1000000)
                .min();
    }

    static long prev(long s) {
        return ((s - a) * v) & N;
    }
}
