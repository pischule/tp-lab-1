package by.bsu.tp.shapes;

import by.bsu.tp.Util;

import java.awt.Polygon;
import java.awt.*;

public class Triangle extends Shape2D {
    private int width;

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

    private int height;

    public Triangle(Color borderColor, Point theCenter, Color fillColor, int width, int height) {
        super(borderColor, theCenter, fillColor);
    }

    public Triangle(Color borderColor, Point theCenter, Color fillColor, Point antherPoint) {
        super(borderColor, theCenter, fillColor);
    }

    @Override
    public void addPoint(Point point) {
        width = 2 * Util.xDistance(getTheCenter(), point);
        height = 2 * Util.yDistance(getTheCenter(), point);
    }

    @Override
    public void draw(Graphics2D g2d) {
        Polygon trianglePolygon = new Polygon();
        trianglePolygon.addPoint(getTheCenter().x - width / 2, getTheCenter().y + height / 2);
        trianglePolygon.addPoint(getTheCenter().x + width / 2, getTheCenter().y + height / 2);
        trianglePolygon.addPoint(getTheCenter().x, getTheCenter().y - height / 2);

        g2d.setStroke(getStroke());
        g2d.setColor(getFillColor());
        g2d.fillPolygon(trianglePolygon);
        g2d.setColor(getBorderColor());
        g2d.drawPolygon(trianglePolygon);
    }
}
