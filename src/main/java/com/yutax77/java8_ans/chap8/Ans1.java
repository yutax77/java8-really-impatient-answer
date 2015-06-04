package com.yutax77.java8_ans.chap8;

public class Ans1 {
    public static long add(int x, int y) {
        return Integer.toUnsignedLong(x) + Integer.toUnsignedLong(y);
    }
    
    public static long substract(int minuend, int subtrahend) {
        return Integer.toUnsignedLong(minuend) - Integer.toUnsignedLong(subtrahend);
    }
    
    public static int divide(int dividend, int divisor) {
        return Integer.divideUnsigned(dividend, divisor);
    }
    
    public static int diff(int x, int y) {
        return Integer.compareUnsigned(x, y);
    }
}
