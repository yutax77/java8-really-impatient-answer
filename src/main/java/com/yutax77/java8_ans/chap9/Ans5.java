package com.yutax77.java8_ans.chap9;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.IntStream;

public class Ans5 {
    public static void writeReverse(Path src, Path dest) throws IOException {
        byte[] bytes = Files.readAllBytes(src);
        String contents = new String(bytes, StandardCharsets.UTF_8);

        int[] codePoints = contents.codePoints().toArray();
        int length = codePoints.length;
        String reversed = IntStream.iterate(length - 1, i -> i - 1).limit(length)
                .map(i -> codePoints[i])
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        Files.write(dest, reversed.getBytes(StandardCharsets.UTF_8));
    }
}
