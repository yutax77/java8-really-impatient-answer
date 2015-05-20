package com.yutax77.java8_ans.chap6;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Ans5_6Test {
    private List<File> files;
    private ExecutorService threadPool;
    private ConcurrentMap<String, Set<File>> collector;
    
    @Before
    public void setUp() throws URISyntaxException {
        File baseDir = new File(getClass().getResource("alice1.txt").toURI()).getParentFile();
        files = new ArrayList<>();
        for(int i = 1; i <= 5; i++) {
            String name = String.format("alice%d.txt", i);
            files.add(new File(baseDir, name));
        }
        
        threadPool = Executors.newFixedThreadPool(5);
        collector = new ConcurrentHashMap<>();
    }
    
    @After
    public void tearDown() {
        threadPool.shutdownNow();
    }
    
    @Test
    public void testAns5_ByMerge() throws IOException, InterruptedException {
        List<Callable<Void>> tasks = new ArrayList<>();
        for(File file: files) {
            tasks.add(new Ans5.WordCollector(file, collector));
        }
        
        threadPool.invokeAll(tasks);
        
        assertThat(collector.values().stream().allMatch(s -> s.containsAll(files)), is(true));
    }

    @Test
    public void testAns6_ByComputeIfAbsent() throws IOException, InterruptedException {
        List<Callable<Void>> tasks = new ArrayList<>();
        for(File file: files) {
            tasks.add(new Ans6.WordCollector(file, collector));
        }
        
        threadPool.invokeAll(tasks);
        
        assertThat(collector.values().stream().allMatch(s -> s.containsAll(files)), is(true));
    }
}
