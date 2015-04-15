package com.yutax77.java8_ans.chap3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Ans12 {
    public static class LatentImage {
	private Image in;
	private List<ColorTransformer> pendingOperations;
	
	protected LatentImage(Image image) {
	    in = image;
	    pendingOperations = new ArrayList<>();
	}
	
	public LatentImage transform(UnaryOperator<Color> f) { 
	    pendingOperations.add(new ColorTransformer() {
                @Override
                public Color apply(int x, int y, Color colorAtXY) {
                    return f.apply(colorAtXY);
                }
            });
	    return this;
	}
	
        public LatentImage transform(ColorTransformer transformer) { 
	    pendingOperations.add(transformer);
	    return this;
	}
        
        public Image toImage() {
            int width = (int) in.getWidth();
            int height = (int) in.getHeight();
            WritableImage out = new WritableImage(width, height);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    Color c = in.getPixelReader().getColor(x, y);
                    for (ColorTransformer transformer : pendingOperations) {
                        c = transformer.apply(x, y, c);
                    }
                    out.getPixelWriter().setColor(x, y, c);
                }
            }
            return out;
        }
        
	public static LatentImage from(Image image) {
	    return new LatentImage(image);
	}
    }
    
    @FunctionalInterface
    public interface ColorTransformer {
        Color apply(int x, int y, Color colorAtXY);
    }
}
