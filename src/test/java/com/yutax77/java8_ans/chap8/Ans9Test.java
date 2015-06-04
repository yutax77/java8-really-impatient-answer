package com.yutax77.java8_ans.chap8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class Ans9Test {
    @Test
    public void testWords() {
        Scanner scanner = new Scanner("あ い う\nえ お\nか");
        Stream<String> result = Ans9.words(scanner);
        List<String> expected = Arrays.asList("あ", "い", "う", "え", "お", "か");
        assertThat(result.collect(Collectors.toList()), is(expected));
    }

    @Test
    public void testLines() {
        Scanner scanner = new Scanner("あ い う\nえ お\nか");
        Stream<String> result = Ans9.lines(scanner);
        List<String> expected = Arrays.asList("あ い う", "え お", "か");
        assertThat(result.collect(Collectors.toList()), is(expected));
    }

    @Test
    public void testDoubles() {
        Scanner scanner = new Scanner("1 2 3 4 5");
        DoubleStream result = Ans9.doubles(scanner);
        double[] expected = new double[]{1.0, 2.0, 3.0, 4.0, 5.0};
        assertThat(result.toArray(), is(expected));
    }

    @Test
    public void testInts() {
        Scanner scanner = new Scanner("1 2 3 4 5");
        IntStream result = Ans9.ints(scanner);
        int[] expected = new int[]{1, 2, 3, 4, 5};
        assertThat(result.toArray(), is(expected));
    }
    
}
