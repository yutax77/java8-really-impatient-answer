package com.yutax77.java8_ans.chap3;

import java.util.function.BiFunction;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Ans6 {
    public static <T> Image transform(Image in, BiFunction<T, Color, Color> f, T arg) {
	int width = (int) in.getWidth();
	int height = (int) in.getHeight();
	WritableImage out = new WritableImage(width, height);
	
	for(int x = 0; x < width; x++) {
	    for(int y = 0; y < height; y++) {
		out.getPixelWriter().setColor(x, y, f.apply(arg, in.getPixelReader().getColor(x, y)));
	    }
	}
	
	return out;
    }
}
