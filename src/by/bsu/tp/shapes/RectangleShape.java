package by.bsu.tp.shapes;

import java.awt.*;

public abstract class RectangleShape extends Shape2D{
    private int width;
    private int height;

    public RectangleShape(Color borderColor, Point theCenter, Color fillColor) {
        super(borderColor, theCenter, fillColor);
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
