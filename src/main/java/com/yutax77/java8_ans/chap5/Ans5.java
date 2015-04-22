package com.yutax77.java8_ans.chap5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ans5 {
    public static long calcAliveDays() {
	LocalDate birth = LocalDate.of(1983, 1, 5);
	LocalDate now = LocalDate.now();
	
	return birth.until(now, ChronoUnit.DAYS);
    }
}
