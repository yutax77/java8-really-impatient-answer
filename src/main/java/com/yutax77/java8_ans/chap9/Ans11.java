package com.yutax77.java8_ans.chap9;

import java.io.File;
import java.io.IOException;

public class Ans11 {
    public static int grep() throws IOException, InterruptedException {
        String homeDir = System.getProperty("user.home");
        ProcessBuilder builder = new ProcessBuilder(
                                        "grep",
                                        "-r", // recursive
                                        "-s", // no-messages
                                        "-I", // ignore binary files
                                        "-E", // extended-regexp
                                        "\\b(?:\\d[ -]*?){13,16}\\b",
                                        homeDir);
        File out = new File("output.txt");
        builder.redirectError(out).redirectOutput(out);
        Process process = builder.start();
        return process.waitFor();
    }
}
