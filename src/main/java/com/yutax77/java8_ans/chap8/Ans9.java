package com.yutax77.java8_ans.chap8;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Ans9 {
    public static Stream<String> words(Scanner scanner) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(scanner, Spliterator.ORDERED
                | Spliterator.NONNULL), false);
    }
    
    public static Stream<String> lines(Scanner scanner) {
        Iterator<String> iter = new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return scanner.hasNextLine();
            }

            @Override
            public String next() {
                if (hasNext()) {
                    return scanner.nextLine();
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iter, Spliterator.ORDERED
                | Spliterator.NONNULL), false);
    }

    public static DoubleStream doubles(Scanner scanner) {
        PrimitiveIterator.OfDouble iter = new PrimitiveIterator.OfDouble() {
            @Override
            public boolean hasNext() {
                return scanner.hasNextDouble();
            }

            @Override
            public double nextDouble() {
                if (hasNext()) {
                    return scanner.nextDouble();
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
        return StreamSupport.doubleStream(
                Spliterators.spliteratorUnknownSize(iter, Spliterator.ORDERED), false);
    }
    
    public static IntStream ints(Scanner scanner) {
        PrimitiveIterator.OfInt iter = new PrimitiveIterator.OfInt() {
            @Override
            public boolean hasNext() {
                return scanner.hasNextInt();
            }
            
            @Override
            public int nextInt() {
                if (hasNext()) {
                    return scanner.nextInt();
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
        return StreamSupport.intStream(
                Spliterators.spliteratorUnknownSize(iter, Spliterator.ORDERED), false);
    }
}
