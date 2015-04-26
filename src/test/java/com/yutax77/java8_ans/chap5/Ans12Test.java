package com.yutax77.java8_ans.chap5;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

import com.yutax77.java8_ans.chap5.Ans12.Plan;
import com.yutax77.java8_ans.chap5.Ans12.Reminder;

public class Ans12Test {
    private String ZONE_ID_NY = "America/New_York";

    @Test
    public void test() {
	Reminder reminder = new Reminder();
	
	Plan plan = new Plan("Teleconference with NY", 
		ZonedDateTime.of(2014, 4, 30, 9, 0, 0, 0, ZoneId.of(ZONE_ID_NY)));
	reminder.add(plan);
	
	
	LocalDateTime t = LocalDateTime.of(2014, 4, 30, 21, 0, 0);
	reminder.remind(t);
    }

}
