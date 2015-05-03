package com.yutax77.java8_ans.chap9;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ans2 {
    public static void scanAndConvertToLowerCase(String srcPath, String outFileName) throws IOException {
        Scanner in = null;
        PrintWriter out = null;

        try {
            in = new Scanner(Paths.get(srcPath));
            out = new PrintWriter(outFileName);
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } catch (Exception e) {
            try {
                closeIfNotNull(in);
                in = null;
            } catch (IOException e1) {
                e.addSuppressed(e1);
            }

            try {
                closeIfNotNull(out);
                out = null;
            } catch (IOException e2) {
                e.addSuppressed(e2);
            }

            throw e;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } finally {
                    if (out != null) {
                        out.close();
                    }
                }
            }
        }
    }

    private static <T extends Closeable> void closeIfNotNull(T closable) throws IOException {
        if (closable != null) {
            closable.close();
        }
    }
}
