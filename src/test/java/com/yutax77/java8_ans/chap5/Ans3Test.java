package com.yutax77.java8_ans.chap5;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class Ans3Test {

    @Test
    public void test1() {
	LocalDate date = LocalDate.of(2015, 4, 19);
	assertThat(date.with(Ans3.next(w -> w.getDayOfWeek().getValue() < 6)), is(LocalDate.of(2015, 4, 20)));
    }

    @Test
    public void test2() {
	LocalDate date = LocalDate.of(2015, 4, 20);
	assertThat(date.with(Ans3.next(w -> w.getDayOfWeek().getValue() < 6)), is(LocalDate.of(2015, 4, 21)));
    }
}
