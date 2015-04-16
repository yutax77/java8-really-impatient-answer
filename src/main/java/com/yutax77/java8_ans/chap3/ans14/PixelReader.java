package com.yutax77.java8_ans.chap3.ans14;

import javafx.scene.paint.Color;

public interface PixelReader {
    public Color get(int x, int y);
    public int getWidth();
    public int getHeight();
}
