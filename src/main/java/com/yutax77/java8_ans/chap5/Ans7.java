package com.yutax77.java8_ans.chap5;

import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.Objects;

public class Ans7 {
    public static class TimeInterval {
       private LocalDateTime start;
       private LocalDateTime end;
       
       TimeInterval(LocalDateTime start, LocalDateTime end) {
           Objects.requireNonNull(start);
           Objects.requireNonNull(end);
           if(start.isAfter(end)) {
               throw new IllegalArgumentException();
           }
          
           this.start = start;
           this.end = end;
       }
       
       public LocalDateTime getStartTime() {
           return start;
       }
       
       public LocalDateTime getEndTime() {
           return end;
       }
       
       public long getInterval(TemporalUnit unit) {
           return unit.between(start, end);
       }
       
       public boolean isOverlap(TimeInterval other) {
           return (other.end.isAfter(start) && other.end.isBefore(end)) || 
                   (other.start.isAfter(start) && other.start.isBefore(end));
       }
       
       public static TimeInterval of(LocalDateTime start, LocalDateTime end) {
           return new TimeInterval(start, end);
       }
    }
}
