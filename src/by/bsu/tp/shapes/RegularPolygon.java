package by.bsu.tp.shapes;

import by.bsu.tp.Util;

import java.awt.*;

public class RegularPolygon extends Shape2D {
    private int squareFrameSize;
    private int numberOfPoints;

    public RegularPolygon(Color borderColor, Point theCenter, Color fillColor, int squareFrameSize, int numberOfPoints) {
        super(borderColor, theCenter, fillColor);
        this.squareFrameSize = squareFrameSize;
        this.numberOfPoints = numberOfPoints;
    }

    public RegularPolygon(Color borderColor, Point theCenter, Color fillColor, Point anotherPoint, int numberOfPoints) {
        super(borderColor, theCenter, fillColor);
        this.numberOfPoints = numberOfPoints;
        setAnotherPoint(anotherPoint);
    }

    @Override
    public void setAnotherPoint(Point point) {
        squareFrameSize = 2 * Util.perpendicularDistance(getTheCenter(), point);
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    @Override
    public void draw(Graphics2D g2d) {

    }

    @Override
    public Point location() {
        return null;
    }
}
