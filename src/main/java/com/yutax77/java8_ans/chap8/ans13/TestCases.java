package com.yutax77.java8_ans.chap8.ans13;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
@interface TestCases {
    TestCase[] value();
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
@Repeatable(TestCases.class)
@interface TestCase {
    int params();
    int expected();
}

