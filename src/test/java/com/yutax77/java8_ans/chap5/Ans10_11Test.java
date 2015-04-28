package com.yutax77.java8_ans.chap5;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class Ans10_11Test {
    @Test
    public void testArrivedTime() {
        ZonedDateTime departure = ZonedDateTime.of(LocalDate.now(), LocalTime.of(3, 5), ZoneId.of("America/Los_Angeles"));
        ZoneId arrivalZoneId = ZoneId.of("Europe/Berlin");
        Duration frightTime = Duration.ofHours(10).plusMinutes(50);
        
        LocalDateTime expResult = LocalDateTime.of(LocalDate.now(), LocalTime.of(22, 55));
        LocalDateTime result = Ans10_11.arrivedTime(departure, arrivalZoneId, frightTime);
        assertEquals(expResult, result);
    }
    
    @Test
    public void tesFrightTime() {
        ZonedDateTime departure = ZonedDateTime.of(LocalDate.now(), LocalTime.of(14, 5), ZoneId.of("Europe/Berlin"));
        ZonedDateTime arrival = ZonedDateTime.of(LocalDate.now(), LocalTime.of(16, 40), ZoneId.of("America/Los_Angeles"));
        
        Duration expResult = Duration.ofHours(11).plusMinutes(35);
        Duration result = Ans10_11.frightTime(departure, arrival);
        assertEquals(expResult, result);
    }    
}
