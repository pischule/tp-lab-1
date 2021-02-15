package by.bsu.tp.shapes;

import java.awt.*;

public class Circle extends Shape2D {
    private double radius;

    public Circle(Color borderColor, Point theCenter, Color fillColor) {
        super(borderColor, theCenter, fillColor);
    }

    @Override
    public void draw() {

    }

    @Override
    public Point location() {
        return null;
    }
}
