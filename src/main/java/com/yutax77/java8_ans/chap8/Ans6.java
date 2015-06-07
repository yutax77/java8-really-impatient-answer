package com.yutax77.java8_ans.chap8;

import java.util.Comparator;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

public class Ans6 {
    public Comparator<Point2D> comparatorPoint2D() {
        return Comparator.comparingDouble(Point2D::getX)
                .thenComparingDouble(Point2D::getY);
    }

    public Comparator<Rectangle2D> comparatorRectangle2D() {
        return Comparator.comparingDouble(Rectangle2D::getHeight)
                .thenComparingDouble(Rectangle2D::getWidth);
    }
}
