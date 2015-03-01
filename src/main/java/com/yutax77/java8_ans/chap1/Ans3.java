package com.yutax77.java8_ans.chap1;

import java.io.File;
import java.io.FilenameFilter;

public class Ans3 {
    public static File[] getFilesByExt(File root, String extention) {
	return root.listFiles(new FilenameFilter() {
	    @Override
	    public boolean accept(File dir, String name) {
		return new File(dir, name).isFile() && name.endsWith("." + extention);
	    }
	});
    }
    
    public static File[] getFilesByExtByLambda(File root, String extention) {
 	return root.listFiles((dir, name) -> (new File(dir, name).isFile() && name.endsWith("." + extention)));
    }
}
