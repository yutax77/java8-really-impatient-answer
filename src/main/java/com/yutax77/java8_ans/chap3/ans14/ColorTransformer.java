package com.yutax77.java8_ans.chap3.ans14;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
    static final int KERNEL_SIZE = 3;
    static final double[][] EDGE_OPERATORS = new double[][]{
                    new double[]{0.0, -1.0, 0.0},
                    new double[]{-1.0, 4.0, -1.0},
                    new double[]{0.0, -1.0, 0.0}
                };
    static final double[][] BLUR_OPERATORS = new double[][]{
                    new double[]{0.125, 0.125, 0.125},
                    new double[]{0.125, 0.0, 0.125},
                    new double[]{0.125, 0.125, 0.125}
                };
    
    
    Color apply(int x, int y, PixelReader reader);
    
    public static ColorTransformer edgeDetector() {
        return (x, y, reader) -> {
            KernelColors kernelColors = KernelColors.getKernelColors(x, y, reader, KERNEL_SIZE);
            return kernelColors.convolve(EDGE_OPERATORS);
        };
    }
     
    public static ColorTransformer blurDetector() {
        return (x, y, reader) -> {
            KernelColors kernelColors = KernelColors.getKernelColors(x, y, reader, KERNEL_SIZE);
            return kernelColors.convolve(BLUR_OPERATORS);
        };
    }
}
