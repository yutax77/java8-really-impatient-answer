package com.yutax77.java8_ans.chap1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.concurrent.Callable;

import org.junit.Test;

import com.yutax77.java8_ans.chap1.Ans6.RunnableEx;

public class Ans6Test {

    @Test(expected = RuntimeException.class)
    public void testUncheck() {
	Exception dummyException = new Exception();
	RunnableEx runnableEx = new RunnableEx() {
	    @Override
	    public void run() throws Throwable {
		System.out.println("Call Runnable#run().");
		throw dummyException;
	    }
	};
	
	try {
	    Runnable wrapped = Ans6.uncheck(runnableEx);
	    wrapped.run();
	}catch(RuntimeException e) {
	    assertThat(e.getCause(), is(dummyException));
	    throw e;
	}
    }
    
    @Test(expected = RuntimeException.class)
    public void testUncheckCallable() {
	Exception dummyException = new Exception();
	Callable<Void> callable = new Callable<Void>() {
	    @Override
	    public Void call() throws Exception {
		System.out.println("Call Callable#call().");
		throw dummyException;
	    }
	};
	
	try {
	    Runnable wrapped = Ans6.uncheck(callable);
	    wrapped.run();
	}catch(RuntimeException e) {
	    assertThat(e.getCause(), is(dummyException));
	    throw e;
	}
    }
}
