package com.yutax77.java8_ans.chap5;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class Ans1Test {
    @Test
    public void test() {
	assertThat(Ans1.calcProgrammersDay(2012), is(LocalDate.of(2012, 9, 12))); //leap year
	assertThat(Ans1.calcProgrammersDay(2013), is(LocalDate.of(2013, 9, 13)));
	assertThat(Ans1.calcProgrammersDay(2014), is(LocalDate.of(2014, 9, 13)));
	assertThat(Ans1.calcProgrammersDay(2015), is(LocalDate.of(2015, 9, 13)));
	assertThat(Ans1.calcProgrammersDay(2016), is(LocalDate.of(2016, 9, 12))); //leap year
    }
}
