package by.bsu.tp.shapes;

import java.awt.*;

public class RegularPolygon extends Shape2D {
    public RegularPolygon(Color borderColor, Point theCenter, Color fillColor, int numberOfPoints) {
        super(borderColor, theCenter, fillColor);
        this.numberOfPoints = numberOfPoints;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    private int numberOfPoints;

    @Override
    public void draw() {

    }

    @Override
    public Point location() {
        return null;
    }
}
