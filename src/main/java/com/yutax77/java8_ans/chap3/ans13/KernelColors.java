package com.yutax77.java8_ans.chap3.ans13;

import javafx.scene.paint.Color;

class KernelColors {
    final int kernelSize;
    final Color[][] kernelColors;
    
    private KernelColors(int kernelSize, Color[][] kernelColors) {
        this.kernelSize = kernelSize;
        this.kernelColors = kernelColors;
    }
    
    Color convolve(double[][] operators) {
        assert operators.length == kernelSize;
        assert operators[0].length == kernelSize;
        
        double sumRed = 0.0;
        double sumGreen = 0.0;
        double sumBlue = 0.0;

        for(int x = 0; x < kernelSize; x++) {
            for(int y = 0; y < kernelSize; y++) {
                Color c = kernelColors[x][y];
                double factor = operators[x][y];

                sumRed += c.getRed() * factor;
                sumGreen += c.getGreen() * factor;
                sumBlue += c.getBlue() * factor;
                
                sumRed = normalize(sumRed);
                sumGreen = normalize(sumGreen);
                sumBlue = normalize(sumBlue);
            }
        }

        return Color.color(sumRed, sumGreen, sumBlue);
    }
    
    private double normalize(double input) {
	if(0.0 > input) {
	    return 0.0;
	}
	
	if(1.0 < input) {
	    return 1.0;
	}
	
	return input;
    }
    
    static KernelColors getKernelColors(int targetX, int targetY, Color[][] target, int kernelSize) {
        Color[][] result = new Color[kernelSize][kernelSize];

        int targetWidth = target.length;
        int targetHeight = target[0].length;

        for(int dx = -1; dx <= 1; dx++) {
            for(int dy = -1; dy <= 1; dy++) {
                int x = targetX + dx;
                int y = targetY + dy;
                Color c = Color.BLACK;
                if((0 <= x && x < targetWidth) && (0 <= y && y < targetHeight)) {
                    c = target[x][y];
                }

                result[dx + 1][dy + 1] = c;
            }
        }

        return new KernelColors(kernelSize, result);
    }    
}
