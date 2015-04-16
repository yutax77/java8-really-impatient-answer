package com.yutax77.java8_ans.chap3;

import java.util.function.Consumer;

public class Ans17 {
    public static void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
        Thread t1 = createExceptionHandledThread(first, handler);
        t1.start();
        
        Thread t2 = createExceptionHandledThread(second, handler);
        t2.start();
    }
    
    private static Thread createExceptionHandledThread(Runnable task, Consumer<Throwable> handler) {
        return new Thread(() -> {
            try{
                task.run();
            } catch (Throwable t) {
                handler.accept(t);
            }        
        });
    }
}