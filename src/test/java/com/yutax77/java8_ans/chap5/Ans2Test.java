package com.yutax77.java8_ans.chap5;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class Ans2Test {
    private LocalDate date;
    
    @Before
    public void setUp() {
	date = LocalDate.of(2000, 2, 29);	
    }
    
    @Test
    public void testPlusOneYear() {
	assertThat(date.plusYears(1), is(LocalDate.of(2001, 2, 28)));
    }
    
    @Test
    public void testPlusFourYear() {
	assertThat(date.plusYears(4), is(LocalDate.of(2004, 2, 29)));
    }
    
    @Test
    public void testPlusOneByOneYear() {
	for(int i = 0; i < 4; i++) {
	    date = date.plusYears(1);
	}
	assertThat(date, is(LocalDate.of(2004, 2, 28)));
    }
}
