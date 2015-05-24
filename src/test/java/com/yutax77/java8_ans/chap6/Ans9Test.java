package com.yutax77.java8_ans.chap6;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.time.Duration;
import java.time.Instant;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.yutax77.java8_ans.chap6.Ans9.Matrix;

@RunWith(Theories.class)
public class Ans9Test {
    @DataPoints
    public static Fixture[] fixture = new Fixture[] {
        new Fixture().degree(1).expected(new long[][] {{1, 1}, {1, 0}}),
        new Fixture().degree(2).expected(new long[][] {{2, 1}, {1, 1}}),
        new Fixture().degree(3).expected(new long[][] {{3, 2}, {2, 1}}),
        new Fixture().degree(4).expected(new long[][] {{5, 3}, {3, 2}}),
        new Fixture().degree(10).expected(new long[][] {{89, 55}, {55, 34}}),
        new Fixture().degree(20).expected(new long[][] {{10946, 6765}, {6765, 4181}}),
        new Fixture().degree(30).expected(new long[][] {{1346269, 832040}, {832040, 514229}}),
        new Fixture().degree(40).expected(new long[][] {{165580141, 102334155}, {102334155, 63245986}}),
        new Fixture().degree(90).expected(new long[][] {{4660046610375530309L, 2880067194370816120L}, {2880067194370816120L, 1779979416004714189L}}),
    };
    
    @Theory
    public void test(Fixture fixture) {
        Instant start = Instant.now();
        Matrix actual = Matrix.multiply(fixture.degree);
        Instant end = Instant.now();
        
        assertThat(actual, is(new Matrix(fixture.expected)));
        System.out.println(String.format("degree: %d, elapsed: %dms.", fixture.degree, Duration.between(start, end).toMillis()));
    }
    
    static class Fixture {
        int degree;
        long[][] expected;
        
        Fixture degree(int multiply) {
            this.degree = multiply;
            return this;
        }
        
        Fixture expected(long[][] expected) {
            this.expected = expected;
            return this;
        }
    }
}
