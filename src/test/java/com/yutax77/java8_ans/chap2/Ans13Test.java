package com.yutax77.java8_ans.chap2;

import java.util.Map;

import org.junit.Test;

public class Ans13Test extends Chap2TestBase {

    @Test
    public void testShortWords() {
	Map<Integer, Long> actual = Ans13.shortWords(words);
	
	//{0=1, 1=1826, 2=4999, 3=7637, 4=6166, 5=3589, 6=2203, 7=1867, 8=831, 9=697, 10=358, 11=149}
	System.out.println(actual);
    }

}
