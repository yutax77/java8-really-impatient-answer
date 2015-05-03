package com.yutax77.java8_ans.chap9;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Ans7 {
    public static void readWebContents(URL url, Path dest) throws IOException {
        try(InputStream in = url.openStream()) {
            Files.copy(in, dest, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
