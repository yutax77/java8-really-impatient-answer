package com.yutax77.java8_ans.chap9;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class Ans7Test {
    @Rule
    public TemporaryFolder tempFile = new TemporaryFolder();
    
    @Test
    public void test() throws IOException {
        File temp = tempFile.newFile("temp.html");
        Ans7.readWebContents(new URL("http://google.com"), temp.toPath());
    }

}
