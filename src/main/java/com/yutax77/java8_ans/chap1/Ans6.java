package com.yutax77.java8_ans.chap1;

import java.util.concurrent.Callable;

public class Ans6 {
    public interface RunnableEx {
	void run() throws Throwable;
    }
    
    public static Runnable uncheck(RunnableEx runner) {
	return () -> {
	    try{
		runner.run();
	    } catch(Throwable e) {
		throw new RuntimeException(e);
	    }
	};
    }
    
    public static Runnable uncheck(Callable<Void> runner) {
	return () -> {
	    try{
		runner.call();
	    } catch(Exception e) {
		throw new RuntimeException(e);
	    }
	};
    }
}
