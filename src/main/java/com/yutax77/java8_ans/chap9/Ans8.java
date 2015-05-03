package com.yutax77.java8_ans.chap9;

public class Ans8 {
    public static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point other) {
            int diff = compareTo(x, other.x); 
            if (diff != 0) return diff;
            return compareTo(y, other.y);
        }
        
        private int compareTo(int x, int y) {
            if(x == y) return 0;
            if(x > y) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
