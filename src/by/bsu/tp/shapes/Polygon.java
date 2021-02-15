package by.bsu.tp.shapes;

import java.awt.*;

public class Polygon extends Shape2D {
    private int numberOfPoints;

    public Polygon(Color borderColor, Point theCenter, Color fillColor) {
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
