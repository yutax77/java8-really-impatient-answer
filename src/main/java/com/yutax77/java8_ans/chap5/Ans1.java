package com.yutax77.java8_ans.chap5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ans1 {
    public static LocalDate calcProgrammersDay(int year) {
	return LocalDate.of(year, 1, 1).plus(255, ChronoUnit.DAYS);
    }
}
