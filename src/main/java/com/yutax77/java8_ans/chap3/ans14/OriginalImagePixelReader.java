package com.yutax77.java8_ans.chap3.ans14;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

class OriginalImagePixelReader implements PixelReader {
    private final Image image;
    
    OriginalImagePixelReader(Image image) {
        this.image = image;
    }
    
    @Override
    public Color get(int x, int y) {
        return image.getPixelReader().getColor(x, y);
    }

    @Override
    public int getWidth() {
        return (int) image.getWidth();
    }

    @Override
    public int getHeight() {
        return (int) image.getHeight();
    } 
}
