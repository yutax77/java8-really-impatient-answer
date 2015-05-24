package com.yutax77.java8_ans.chap6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ans10 {
    static CompletableFuture<String> getContents(URL url) throws IOException {
        StringBuilder buf = new StringBuilder();
        try(Reader in = new BufferedReader(new InputStreamReader
                (url.openStream(), StandardCharsets.UTF_8.name()))) {
            int c = 0;
            while ((c = in.read()) != -1) {
                buf.appendCodePoint(c);
            }
        }
        return CompletableFuture.completedFuture(buf.toString());
    }
    
    static CompletableFuture<List<String>> getLinks(String contents) {
        Pattern ptn = Pattern.compile("<a.*?href=\"(.*?)\".*?>(.*?)</a>");

        Matcher matcher = ptn.matcher(contents);
        List<String> results = new ArrayList<>();
        while (matcher.find()) {
            String href = matcher.group(1);
            results.add(href);
        }
        
        return CompletableFuture.completedFuture(results);
    }
}
