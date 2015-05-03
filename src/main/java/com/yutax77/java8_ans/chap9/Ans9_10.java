package com.yutax77.java8_ans.chap9;

import java.util.Objects;

public class Ans9_10 {
    public static class LabeledPoint implements Comparable<LabeledPoint> {
        private String label;
        private int x;
        private int y;

        public LabeledPoint(String label, int x, int y) {
            this.label = label;
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(label, x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            LabeledPoint other = (LabeledPoint) obj;
            if (!Objects.equals(label, other.label))
                return false;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }

        @Override
        public int compareTo(LabeledPoint o) {
            int diff = label.compareTo(o.label);
            if(diff != 0)
                return diff;
            diff = Integer.compare(x, o.x);
            if(diff != 0)
                return diff;
            diff = Integer.compare(y, o.y);
            if(diff != 0)
                return diff;
            return 0;
        }
    }
}
