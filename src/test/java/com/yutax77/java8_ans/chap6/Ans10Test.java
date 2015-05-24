package com.yutax77.java8_ans.chap6;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class Ans10Test {
    @Test
    public void test() throws IOException {
        URL url = new URL("http://google.co.jp");
        Ans10.getContents(url).thenCompose(Ans10::getLinks)
                .thenAccept(System.out::println);
        ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
    }
}
