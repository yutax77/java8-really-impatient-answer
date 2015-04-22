package com.yutax77.java8_ans.chap5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

public class Ans3 {
    public static TemporalAdjuster next(Predicate<? super LocalDate> predicate) {
	return TemporalAdjusters.ofDateAdjuster(date -> {
	    LocalDate result = date;
	    do{
		result = result.plus(1, ChronoUnit.DAYS);		
	    }while(!predicate.test(result));
	    
	    return result;
	});
    }
}
