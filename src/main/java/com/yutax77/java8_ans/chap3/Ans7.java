package com.yutax77.java8_ans.chap3;

import java.util.Comparator;

public class Ans7 {

    public static Comparator<String> generateComparator(
                                        boolean isReverse,
                                        boolean isIgnoreCase,
                                        boolean isIgnoreWhiteSpace) {
        Comparator<String> result;

        if (isIgnoreCase) {
            result = (s1, s2) -> (s1.compareToIgnoreCase(s2));
        } else {
            result = (s1, s2) -> (s1.compareTo(s2));
        }

        if (isIgnoreWhiteSpace) {
            result = result.thenComparing(s -> {
                String[] splited = s.split("[\\s]+");
                return String.join("", splited);
            });
        }

        if (isReverse) {
            return result.reversed();
        } else {
            return result;
        }
    }
}
