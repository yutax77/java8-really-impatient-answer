package com.yutax77.java8_ans.chap3;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Ans5Test {  
    private Image original;
    
    @Before
    public void setUp() {
        original = new Image(getClass().getResourceAsStream("queen-mary.png"));
    }

    @Test
    public void testTransform() {
        int width = (int) original.getWidth();
        int height = (int) original.getHeight();
        
        Image actual = Ans5.transform(original, (x, y, color) -> {
            if(10 > x || (width - 1 - x) < 10 || 10 > y || (height - 1 - y) < 10) {
                return Color.GRAY;
            } else {
                return color;
            }
        });
        
        Image expected = new Image(getClass().getResourceAsStream("queen-mary-gray-framed.png"));
        assetImage(actual, expected);
    }
    
    static void assetImage(Image actual, Image expected) {
        int width = (int) expected.getWidth();
        int height = (int) expected.getHeight(); 
        
        assertThat("Different width.", (int) actual.getWidth(), is(width));
        assertThat("Different height.", (int) actual.getHeight(), is(height));
        
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                assertThat("Different color at(" + x + "," + y + ")",
                        actual.getPixelReader().getColor(x, y), 
                        is(expected.getPixelReader().getColor(x, y)));
            }
        }
    }
}
