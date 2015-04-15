package com.yutax77.java8_ans.chap3;

import java.util.Arrays;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class Ans7Test {
    private static final String[] STRINGS = new String[]{
        "aa",
        "a b",
        "AA",
        "A B",
    };
    
    @DataPoints
    public static final Fixture[] fixtures = new Fixture[] {
        new Fixture().isReverseOrder(false).isIgnoreCase(false).isIgnoreWhiteSpace(false).expected(new String[]{"A B", "AA", "a b", "aa"}),
        new Fixture().isReverseOrder(false).isIgnoreCase(false).isIgnoreWhiteSpace(true).expected(new String[]{"A B", "AA", "a b", "aa"}),
        new Fixture().isReverseOrder(false).isIgnoreCase(true).isIgnoreWhiteSpace(false).expected(new String[]{"a b", "A B", "aa", "AA"}),
        new Fixture().isReverseOrder(false).isIgnoreCase(true).isIgnoreWhiteSpace(true).expected(new String[]{"A B", "a b", "AA", "aa"}),
        new Fixture().isReverseOrder(true).isIgnoreCase(false).isIgnoreWhiteSpace(false).expected(new String[]{"aa", "a b", "AA", "A B"}),
        new Fixture().isReverseOrder(true).isIgnoreCase(false).isIgnoreWhiteSpace(true).expected(new String[]{"aa", "a b", "AA", "A B"}),
        new Fixture().isReverseOrder(true).isIgnoreCase(true).isIgnoreWhiteSpace(false).expected(new String[]{"aa", "AA", "a b", "A B"}),
        new Fixture().isReverseOrder(true).isIgnoreCase(true).isIgnoreWhiteSpace(true).expected(new String[]{"aa", "AA", "a b", "A B"}),
    };
    
    @Theory
    public void test(Fixture fixture) {
        String[] arrays = Arrays.copyOf(STRINGS, STRINGS.length);
        Arrays.sort(arrays, Ans7.generateComparator(fixture.isReverseOrder, fixture.isIgnoreCase, fixture.isIgnoreWhiteSpace));
    
        assertThat(arrays, is(fixture.expected));
    }
    
    static class Fixture {
        boolean isReverseOrder;
        boolean isIgnoreCase;
        boolean isIgnoreWhiteSpace;
        String[] expected;
        
        Fixture isReverseOrder(boolean isReversedOrder) {
            this.isReverseOrder = isReversedOrder;
            return this;
        }
        
        Fixture isIgnoreCase(boolean isIgnoreCase) {
            this.isIgnoreCase = isIgnoreCase;
            return this;
        }
        
        Fixture isIgnoreWhiteSpace(boolean isIgnoreWhiteSpace) {
            this.isIgnoreWhiteSpace = isIgnoreWhiteSpace;
            return this;
        }
        
        Fixture expected(String[] expected) {
            this.expected = expected;
            return this;
        }
    }
}
