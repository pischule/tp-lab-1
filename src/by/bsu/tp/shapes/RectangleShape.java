package by.bsu.tp.shapes;

import by.bsu.tp.Util;

import java.awt.*;

public abstract class RectangleShape extends Shape2D {
    private int width;
    private int height;

    public RectangleShape(Color borderColor, Point theCenter, Color fillColor, int width, int height) {
        super(borderColor, theCenter, fillColor);
        this.width = width;
        this.height = height;
    }

    public RectangleShape(Color borderColor, Point theCenter, Color fillColor, Point antherPoint) {
        super(borderColor, theCenter, fillColor);
        setAnotherPoint(antherPoint);
    }

    @Override
    public void setAnotherPoint(Point point) {
        width = 2 * Util.xDistance(getTheCenter(), point);
        height = 2 * Util.yDistance(getTheCenter(), point);
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
