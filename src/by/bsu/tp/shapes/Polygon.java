package by.bsu.tp.shapes;

import java.awt.*;
import java.util.ArrayList;

public class Polygon extends Shape2D {
    private ArrayList<Point> points;

    public Polygon(Color borderColor, Point theCenter, Color fillColor, ArrayList<Point> points) {
        super(borderColor, theCenter, fillColor);
        this.points = points;
    }

    public Polygon(Color borderColor, Point theCenter, Color fillColor, Point p) {
        super(borderColor, theCenter, fillColor);
        points = new ArrayList<>();
        points.add(p);
    }

    @Override
    public void updateLastPoint(Point point) {
        if (points.size() > 0) {
            points.set(points.size() - 1, point);
        }
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public void draw(Graphics2D g2d) {
        java.awt.Polygon polygon = new java.awt.Polygon();
        polygon.addPoint(getTheCenter().x, getTheCenter().y);
        points.forEach(p -> polygon.addPoint(p.x, p.y));

        g2d.setColor(getFillColor());
        g2d.fillPolygon(polygon);
        g2d.setColor(getBorderColor());
        g2d.drawPolygon(polygon);
    }
}
