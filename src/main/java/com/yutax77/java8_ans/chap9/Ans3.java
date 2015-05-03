package com.yutax77.java8_ans.chap9;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;

public class Ans3 {
    public static void catchMultiException() throws IOException {
        try {
            throwFileNotFoundException();
            throwUnknownHostException();
        } catch (FileNotFoundException | UnknownHostException ex) {
            throw ex;
        }
    }

    private static void throwFileNotFoundException() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    private static void throwUnknownHostException() throws UnknownHostException {
        throw new UnknownHostException();
    }
}
