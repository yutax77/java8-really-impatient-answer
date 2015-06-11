package com.yutax77.java8_ans.chap8;

import com.yutax77.java8_ans.chap2.Chap2TestBase;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import org.junit.Test;

public class Ans15Test {

    @Test
    public void testGrep() throws Exception {
        Path path = Paths.get(Chap2TestBase.class.getResource("alice.txt").toURI());
        Pattern pattern = Pattern.compile("^Author");
        
        Ans15.grep(path, pattern);
    }
    
}
