package by.bsu.tp.shapes;

import by.bsu.tp.Util;

import java.awt.Polygon;
import java.awt.*;
import java.util.ArrayList;

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
        addPoint(anotherPoint);
    }

    @Override
    public void addPoint(Point point) {
        squareFrameSize = 2 * Util.perpendicularDistance(getTheCenter(), point);
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    private ArrayList<Point> getPoints() {
        ArrayList<Point> points = new ArrayList<>();
        double radius = squareFrameSize / 2.0;
        double angle;
        for (int i = 0; i < numberOfPoints; ++i) {
            angle = 2.0 * Math.PI / numberOfPoints * (i);
            points.add(new Point((int) (getTheCenter().x + radius * Math.cos(angle)),
                    (int) (getTheCenter().y + radius * Math.sin(angle))));
        }
        return points;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Polygon awtPolygon = new Polygon();
        getPoints().forEach(x -> awtPolygon.addPoint(x.x, x.y));

        g2d.setColor(getFillColor());
        g2d.fillPolygon(awtPolygon);
        g2d.setColor(getBorderColor());
        g2d.drawPolygon(awtPolygon);
    }

    @Override
    public Point location() {
        return null;
    }
}
