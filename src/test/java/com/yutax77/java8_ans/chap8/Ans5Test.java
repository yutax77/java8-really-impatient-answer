package com.yutax77.java8_ans.chap8;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import com.yutax77.java8_ans.chap2.Chap2TestBase;

public class Ans5Test extends Chap2TestBase {
    @Test
    public void test() {
        long actual = Ans5.countLongWord(words);
        assertThat(actual, is(33L));
    }
}
