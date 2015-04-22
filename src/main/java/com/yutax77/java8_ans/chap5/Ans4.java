package com.yutax77.java8_ans.chap5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Ans4 {
    public static class Cal {
	private final LocalDate startDate;
	
	public Cal(int year, int month) {
	    startDate = LocalDate.of(year, month, 1);
	}
	
	public void show() {
	    List<String[]> calender = calcClender();
	    for(String[] week: calender) {
		String joined = String.join("\t", week);
		System.out.println(joined);
	    }
	}
	
	private List<String[]> calcClender() {
	    LocalDate date = startDate;
	    boolean isLeap = date.isLeapYear();
	    int maxDay = date.getMonth().length(isLeap);
	    
	    List<String[]> results = new ArrayList<>();
	    String[] temp = initArray();
	    for(int i = 0; i < maxDay; i++) {
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		temp[dayOfWeek.getValue() - 1] = String.valueOf(date.getDayOfMonth());
		if(dayOfWeek == DayOfWeek.SUNDAY || date.getDayOfMonth() == maxDay) {
		    results.add(temp);
		    temp = initArray();
		}
		date = date.plusDays(1);
	    }
	    
	    return results;
	}
	
	private String[] initArray() {
	    return Stream.generate(() -> "").limit(7).toArray(String[]::new);
	}
    }
}
