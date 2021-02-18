package by.bsu.tp.shapes;

import java.awt.*;
import java.awt.Polygon;

public class Rhomb extends RectangleShape{

    public Rhomb(Color borderColor, Point theCenter, Color fillColor, int width, int height) {
        super(borderColor, theCenter, fillColor, width, height);
    }

    public Rhomb(Color borderColor, Point theCenter, Color fillColor, Point antherPoint) {
        super(borderColor, theCenter, fillColor, antherPoint);
    }

    @Override
    public void draw(Graphics2D g2d) {
        Polygon awtPoly = new Polygon();
        awtPoly.addPoint(getTheCenter().x-getWidth()/2, getTheCenter().y);
        awtPoly.addPoint(getTheCenter().x, getTheCenter().y - getHeight()/2);
        awtPoly.addPoint(getTheCenter().x+getWidth()/2, getTheCenter().y);
        awtPoly.addPoint(getTheCenter().x, getTheCenter().y + getHeight()/2);
        g2d.fillPolygon(awtPoly);
    }

    @Override
    public Point location() {
        return null;
    }
}
