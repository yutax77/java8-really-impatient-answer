package com.yutax77.java8_ans.chap3.ans14;

import javafx.scene.paint.Color;

class CachedPixelReader implements PixelReader {
    private final PixelReader previous;
    private final int width;
    private final int height;
    private final ColorTransformer transformer;
    private final Color[][] cache;

    CachedPixelReader(PixelReader previous, int width, int height, ColorTransformer transformer) {
        this.previous = previous;
        this.width = width;
        this.height = height;
        this.transformer = transformer;
        cache = new Color[width][height];
    }
    
    @Override
    public Color get(int x, int y) {
        Color result = cache[x][y];
        if(result != null){
            return result;
        }
        
        result = transformer.apply(x, y, previous);
        cache[x][y] = result;
        return result;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
