package com.yutax77.java8_ans.chap8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Ans15 {
    public static void grep(Path path, Pattern pattern) throws IOException {
        Files.lines(path).filter(pattern.asPredicate()).forEach(System.out::println);
    }
}
