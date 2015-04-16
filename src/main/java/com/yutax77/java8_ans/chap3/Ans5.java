package com.yutax77.java8_ans.chap3;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Ans5 {
    public static Image transform(Image image, ColorTransformer transformer) {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        WritableImage out = new WritableImage(width, height);
        
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y, transformer.apply(x, y, image.getPixelReader().getColor(x, y)));
            }
        }
        return out;
    }
    
    @FunctionalInterface
    public interface ColorTransformer {
        Color apply(int x, int y, Color colorAtXY);
    }
}
