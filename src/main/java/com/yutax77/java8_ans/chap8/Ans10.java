package com.yutax77.java8_ans.chap8;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;


public class Ans10 {
    public static void walk(Path target) throws IOException {
        AtomicInteger count = new AtomicInteger();
        Files.walk(target).filter(p -> {
            return p.toFile().getAbsolutePath().endsWith(".java");
        }).flatMap(p -> {
            String s = readAll(p);
            if(s.contains("volatile") && s.contains("transient")) {
                return Stream.of(p);
            } else {
                return Stream.empty();
            }
        }).forEach(p -> {
            System.out.println(p);
            count.incrementAndGet();
        });
        
        System.out.println("Hit:" + count.get());
    }
    
    private static String readAll(Path path) {
        try {
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
