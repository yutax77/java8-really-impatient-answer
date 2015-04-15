package com.yutax77.java8_ans.chap3.ans13;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

class LatentImage {

    private final Image in;
    private final int width;
    private final int height;
    private List<ConvoluteColorTransformer> pendingOperations;

    protected LatentImage(Image image) {
        in = image;
        width = (int) in.getWidth();
        height = (int) in.getHeight();

        pendingOperations = new ArrayList<>();
    }

    public LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(new ConvoluteColorTransformer() {
            @Override
            public Color apply(int x, int y, Color[][] colors) {
                return f.apply(colors[x][y]);
            }
        });
        return this;
    }

    public LatentImage transform(ColorTransformer transformer) {
        pendingOperations.add(new ConvoluteColorTransformer() {
            @Override
            public Color apply(int x, int y, Color[][] colors) {
                return transformer.apply(x, y, colors[x][y]);
            }
        });
        return this;
    }

    public LatentImage convolve(ConvoluteColorTransformer transformer) {
        pendingOperations.add(transformer);
        return this;
    }

    public Image toImage() {
        Color[][] previous = toColorArrays();
        Color[][] temp = new Color[width][height];
        for (ConvoluteColorTransformer transformer : pendingOperations) {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    temp[x][y] = transformer.apply(x, y, previous);
                }
            }
            previous = temp;
        }

        return toImage(temp);
    }

    private Color[][] toColorArrays() {
        Color[][] result = new Color[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                result[x][y] = in.getPixelReader().getColor(x, y);
            }
        }

        return result;
    }

    private Image toImage(Color[][] colorArrays) {
        WritableImage out = new WritableImage(width, height);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y, colorArrays[x][y]);
            }
        }

        return out;
    }

    public static LatentImage from(Image image) {
        return new LatentImage(image);
    }
}
