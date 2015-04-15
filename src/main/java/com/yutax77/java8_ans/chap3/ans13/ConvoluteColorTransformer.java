package com.yutax77.java8_ans.chap3.ans13;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface ConvoluteColorTransformer {
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
    
    Color apply(int x, int y, Color[][] colors);
        
    public static ConvoluteColorTransformer edgeDetector() {
        return (x, y, colors) -> {
            KernelColors kernelColors = KernelColors.getKernelColors(x, y, colors, KERNEL_SIZE);
            return kernelColors.convolve(EDGE_OPERATORS);

        };
    }
     
    public static ConvoluteColorTransformer blurDetector() {
        return (x, y, colors) -> {
            KernelColors kernelColors = KernelColors.getKernelColors(x, y, colors, KERNEL_SIZE);
            return kernelColors.convolve(BLUR_OPERATORS);

        };
    }
}
