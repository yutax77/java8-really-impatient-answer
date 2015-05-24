package com.yutax77.java8_ans.chap6;

import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ans11 {
    public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
        return CompletableFuture.supplyAsync(action).thenCompose(t -> {
            if(until.test(t)) {
                return CompletableFuture.completedFuture(t);
            } else {
                return repeat(action, until);
            }
        });
    }
}
