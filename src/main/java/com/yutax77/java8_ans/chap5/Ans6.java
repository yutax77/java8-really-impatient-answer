package com.yutax77.java8_ans.chap5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Ans6 {
    public static long friday13th() {
	LocalDate start = LocalDate.of(1900, 1, 1);
	LocalDate end = LocalDate.of(2000, 1, 1);
	
	int count = 0;
	for(LocalDate date = start; date.isBefore(end); date = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY))) {
	    if(date.getDayOfMonth() == 13) {
		count++;
	    }
	}
	
	return count;
    }
}
