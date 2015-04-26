package com.yutax77.java8_ans.chap5;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Ans12 {
    public static class Reminder {
	private static final long ONE_HOUR_AS_MINUTES = 60;
	
	private final List<Plan> plans;
	
	public Reminder() {
	    plans = new ArrayList<>();
	}
	
	public void add(Plan plan) {
	    plans.add(plan);
	}
	
	public void remind(LocalDateTime localDateTime) {
	    ZoneId zoneId = ZoneId.systemDefault();
	    ZonedDateTime current = localDateTime.atZone(zoneId);
	    System.out.println(current);
	    
	    plans.stream()
	    	.map(p -> p.convertTimeZone(zoneId))
	    	.filter(p -> {
	    	    return ONE_HOUR_AS_MINUTES >= ChronoUnit.MINUTES.between(current, p.getPlanedDateTime());
	    	})
	    	.forEach(System.out::println);
	}
    }
    
    public static class Plan {
	private final String name;
	private final ZonedDateTime planedTime;
	
	public Plan(String name, ZonedDateTime planedTime) {
	    this.name = name;
	    this.planedTime = planedTime;
	}
	
	public ZonedDateTime getPlanedDateTime() {
	    return planedTime;
	}
	
	public Plan convertTimeZone(ZoneId zoneId) {
	    return new Plan(name, planedTime.withZoneSameInstant(zoneId));
	}
	
	@Override
	public String toString() {
	    StringBuilder buf = new StringBuilder();
	    buf.append("\"").append(name).append("\" start at ");
	    buf.append(getPlanedDateTime());
	    return buf.toString();
	}
    }
}
