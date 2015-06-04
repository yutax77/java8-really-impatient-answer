package com.yutax77.java8_ans.chap8;

import static java.lang.Math.*;

public class Ans3 {
    public static int gcd_mod(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcd_mod(b, abs(a % b));
        }
    }
    
    public static int gcd_floorMod(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcd_floorMod(b, floorMod(a, abs(b)));
        }
    }
    
    public static int gcd_rem(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcd_rem(b, rem(a, b));
        }
    }
    
    private static int rem(int a, int b) {
        return (floorMod(a, b) + abs(b)) % abs(b);
    }
}
