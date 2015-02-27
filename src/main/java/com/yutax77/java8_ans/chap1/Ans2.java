package com.yutax77.java8_ans.chap1;

import java.io.File;
import java.io.FileFilter;

public class Ans2 {
    public static File[] getSubDirs(File root) {
	return root.listFiles(new FileFilter() {
	    public boolean accept(File pathname) {
		return pathname.isDirectory();
	    }
	});
    }
    
    public static File[] getSubDirsByLambda(File root) {
	return root.listFiles(file -> file.isDirectory());
    }
    
    public static File[] getSubDirsByLambda2(File root) {
	return root.listFiles(File::isDirectory);
    }
}
