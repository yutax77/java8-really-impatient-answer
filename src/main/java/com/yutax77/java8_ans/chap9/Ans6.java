package com.yutax77.java8_ans.chap9;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Ans6 {
    public static void writeReverse(Path src, Path dest) throws IOException {
        List<String> lines = Files.readAllLines(src);
        java.util.Collections.reverse(lines);

        lines.stream()
            .map(s -> s + "\n")
            .forEach(s -> {
                try {
                    Files.write(dest, s.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
    }
}
