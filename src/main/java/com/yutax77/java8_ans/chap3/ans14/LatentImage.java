package com.yutax77.java8_ans.chap3.ans14;

import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

class LatentImage {
    private final PixelReader reader;
    private final int width;
    private final int height;

    protected LatentImage(Image image) {
        width = (int) image.getWidth();
        height = (int) image.getHeight();
        reader = new OriginalImagePixelReader(image);
    }
    
    protected LatentImage(PixelReader reader) {
        this.reader = reader;
        this.width = reader.getWidth();
        this.height = reader.getHeight();
    }
    
    public LatentImage transform(UnaryOperator<Color> f) {
        return transform((x, y, reader) -> {
            return f.apply(reader.get(x, y));
        });
    }

    public LatentImage transform(ColorTransformer transformer) {
        return new LatentImage(new CachedPixelReader(reader, width, height, transformer));
    }

    public Image toImage() {
        WritableImage result = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                result.getPixelWriter().setColor(x, y, reader.get(x, y));
            }
        }

        return result;
    }

    public static LatentImage from(Image image) {
        return new LatentImage(image);
    }
}
