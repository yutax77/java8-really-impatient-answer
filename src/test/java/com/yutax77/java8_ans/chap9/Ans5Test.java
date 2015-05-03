package com.yutax77.java8_ans.chap9;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class Ans5Test {
    @Rule
    public TemporaryFolder tempFile = new TemporaryFolder();
    private Path src;

    @Before
    public void setUp() throws URISyntaxException {
        src = Paths.get(getClass().getResource("src.txt").toURI());
    }

    @Test
    public void testWriteReverse() throws IOException, URISyntaxException {
        File temp = tempFile.newFile();
        Ans5.writeReverse(src, temp.toPath());

        byte[] expected = Files.readAllBytes(Paths.get(getClass().getResource(
                "src_char_reverse_order.txt").toURI()));
        byte[] actual = Files.readAllBytes(temp.toPath());
        assertThat(actual, is(expected));
    }
}
