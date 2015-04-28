package com.yutax77.java8_ans.chap5;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Ans9 {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("VV z xxx");
    
    public static void offset() {
        Instant now = Instant.now();
        ZoneId.getAvailableZoneIds().stream()
                .map(s -> now.atZone(ZoneId.of(s)))
                .filter(z -> (z.getOffset().getTotalSeconds() % 3600 != 0))
                .sorted()
                .forEach(z -> {
                    System.out.println(z.format(formatter));
                });
    }    
}
