package com.yutax77.java8_ans.chap3;

import java.util.concurrent.locks.ReentrantLock;

public class Ans2 {
    public static void withLock(ReentrantLock lock, Runnable runnable) {
	lock.lock();
	try {
	    runnable.run();
	} finally {
	    lock.unlock();
	}
    }
}
