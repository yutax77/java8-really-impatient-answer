package com.yutax77.java8_ans.chap6;

import java.util.Arrays;

public class Ans9 {
    static class Matrix {
        long[][] matrix;
        
        Matrix() {
            matrix = new long[2][2];
            Arrays.parallelSetAll(matrix[0], i -> 1);
            Arrays.parallelSetAll(matrix[1], i -> 1 - i);
        }
        
        Matrix(long[][] matrix) {
            this.matrix = matrix;
        }
        
        public long get(int x, int y) {
            return matrix[y][x];
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + Arrays.hashCode(matrix);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Matrix other = (Matrix) obj;
            if (!Arrays.deepEquals(matrix, other.matrix))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "Matrix [matrix=" + Arrays.deepToString(matrix) + "]";
        }

        public Matrix multiply(Matrix m) {
            long[][] result = new long[2][2];
            
            result[0][0] = (get(0, 0) * m.get(0, 0)) + (get(0, 1) * m.get(1, 0));
            result[0][1] = (get(0, 0) * m.get(1, 0)) + (get(0, 1) * m.get(1, 1));
            result[1][0] = (get(0, 1) * m.get(0, 0)) + (get(1, 1) * m.get(1, 0));
            result[1][1] = (get(0, 1) * m.get(1, 0)) + (get(1, 1) * m.get(1, 1));
            
            return new Matrix(result);
        }
        
        static Matrix multiply(int degree) {
            Matrix[] matrixes = new Matrix[degree];
            Arrays.parallelSetAll(matrixes, i -> new Matrix());
            
            Arrays.parallelPrefix(matrixes, (x, y) -> x.multiply(y));
            return matrixes[degree - 1];
        }
    }
}
