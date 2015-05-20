package com.yutax77.java8_ans.chap6;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

public class Ans5 {
    public static class WordCollector implements Callable<Void> {
        private final File file;
        private final List<String> words;
        private final ConcurrentMap<String, Set<File>> collector;
        
        public WordCollector(File file, ConcurrentMap<String, Set<File>> collector) throws IOException {
            this.file = file;
            
            String contents = new String(Files.readAllBytes(file.toPath()),
                    StandardCharsets.UTF_8); 
            words = Arrays.asList(contents.split("[\\P{L}]+"));
            
            this.collector = collector;
        }
        
        @Override
        public Void call() {
            for(String word: words) {
                collector.merge(
                        word, 
                        new HashSet<File>(Arrays.asList(file)), 
                        (oldVal, val) -> {
                            val.addAll(oldVal);
                            return val;
                        });
                
            }
            return null;
        }
    }
}
