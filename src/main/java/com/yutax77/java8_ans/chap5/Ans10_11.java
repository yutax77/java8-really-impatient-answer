package com.yutax77.java8_ans.chap5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Ans10_11 {
    public static LocalDateTime arrivedTime(ZonedDateTime departure, ZoneId arrivalZoneId, Duration frightTime) {
        return departure.plus(frightTime).withZoneSameInstant(arrivalZoneId).toLocalDateTime();
    }
    
    public static Duration frightTime(ZonedDateTime departure, ZonedDateTime arrival) {
        return Duration.between(departure, arrival);
    }
}
