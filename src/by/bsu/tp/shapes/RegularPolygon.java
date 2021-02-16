package by.bsu.tp.shapes;

import by.bsu.tp.Util;

import java.awt.*;

public class RegularPolygon extends Shape2D {
    public RegularPolygon(Color borderColor, Point theCenter, Color fillColor, int squareFrameSize, int numberOfPoints) {
        super(borderColor, theCenter, fillColor);
        this.squareFrameSize = squareFrameSize;
        this.numberOfPoints = numberOfPoints;
    }

    @Override
    public void setAnotherPoint(Point point) {
        squareFrameSize = 2 * Util.perpendicularDistance(getTheCenter(), point);
    }

    private int squareFrameSize;

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    private int numberOfPoints;

    @Override
    public void draw(Graphics2D g2d) {

    }

    @Override
    public Point location() {
        return null;
    }
}
