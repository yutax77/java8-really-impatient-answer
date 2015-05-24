package com.yutax77.java8_ans.chap6;

import java.net.PasswordAuthentication;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class Ans11Test {

    @Test
    public void test() throws InterruptedException, ExecutionException {
        CompletableFuture<PasswordAuthentication> future = Ans11.repeat(() -> {
            Scanner input = new Scanner(System.in);
            System.out.println("username:");
            String userName = input.nextLine();
            System.out.println("password:");
            String password = input.nextLine();

            return new PasswordAuthentication(userName, password.toCharArray());
        }, t -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                String password = new String(t.getPassword());
                return password.equals("secret");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        future.get();
    }
}
