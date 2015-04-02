package com.yutax77.java8_ans.chap2;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class Ans12Test extends Chap2TestBase {

    @Test
    public void testShortWords() {
	AtomicInteger[] actual = Ans12.shortWords(words);
	
	//[1, 1826, 4999, 7637, 6166, 3589, 2203, 1867, 831, 697, 358, 149]
	System.out.println(Arrays.toString(actual));
    }

}
