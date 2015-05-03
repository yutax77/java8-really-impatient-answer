package com.yutax77.java8_ans.chap9;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ans1 {
    public static void scanAndConvertToLowerCase(String srcPath, String outFileName) throws IOException {
        Scanner in = null;
        PrintWriter out = null;

        try {
            in = new Scanner(Paths.get(srcPath));
            out = new PrintWriter(outFileName);
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
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
}
