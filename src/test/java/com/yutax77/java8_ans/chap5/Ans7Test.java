package com.yutax77.java8_ans.chap5;

import com.yutax77.java8_ans.chap5.Ans7.TimeInterval;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class Ans7Test {
    @Test
    public void testGetInterval() {
        TimeInterval interval = TimeInterval.of(
                                    LocalDateTime.of(2014, 4, 27, 11, 00, 00),
                                    LocalDateTime.of(2014, 4, 28, 11, 00, 00));
        
        assertThat(interval.getInterval(ChronoUnit.HOURS), is(24L));
        assertThat(interval.getInterval(ChronoUnit.DAYS), is(1L));
    }
    
    @Test
    public void testIsOverlap() {
        TimeInterval interval1 = TimeInterval.of(
                                    LocalDateTime.of(2014, 4, 27, 11, 00, 00),
                                    LocalDateTime.of(2014, 4, 27, 15, 00, 00));
        TimeInterval interval2 = TimeInterval.of(
                                    LocalDateTime.of(2014, 4, 27, 5, 00, 00),
                                    LocalDateTime.of(2014, 4, 27, 8, 00, 00));
        TimeInterval interval3 = TimeInterval.of(
                                    LocalDateTime.of(2014, 4, 27, 8, 00, 00),
                                    LocalDateTime.of(2014, 4, 27, 11, 00, 00));
        TimeInterval interval4 = TimeInterval.of(
                                    LocalDateTime.of(2014, 4, 27, 9, 00, 00),
                                    LocalDateTime.of(2014, 4, 27, 12, 00, 00));
        TimeInterval interval5 = TimeInterval.of(
                                    LocalDateTime.of(2014, 4, 27, 14, 00, 00),
                                    LocalDateTime.of(2014, 4, 27, 17, 00, 00));
        TimeInterval interval6 = TimeInterval.of(
                                    LocalDateTime.of(2014, 4, 27, 15, 00, 00),
                                    LocalDateTime.of(2014, 4, 27, 18, 00, 00));
        TimeInterval interval7 = TimeInterval.of(
                                    LocalDateTime.of(2014, 4, 27, 16, 00, 00),
                                    LocalDateTime.of(2014, 4, 27, 19, 00, 00));
        
        assertThat(interval1.isOverlap(interval2), is(false));
        assertThat(interval1.isOverlap(interval3), is(false));
        assertThat(interval1.isOverlap(interval4), is(true));
        assertThat(interval1.isOverlap(interval5), is(true));
        assertThat(interval1.isOverlap(interval6), is(false));
        assertThat(interval1.isOverlap(interval7), is(false));
    }
}
