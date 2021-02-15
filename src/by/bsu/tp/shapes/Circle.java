package by.bsu.tp.shapes;

import java.awt.*;

public class Circle extends Shape2D {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Circle(Color borderColor, Point theCenter, Color fillColor, int radius) {
        super(borderColor, theCenter, fillColor);
        this.radius = radius;
    }

    @Override
    public void draw() {

    }

    @Override
    public Point location() {
        return null;
    }
}
