package by.bsu.tp.shapes;

import by.bsu.tp.Util;

import java.awt.*;

public class Square extends Shape2D {
    private int side;

    public Square(Color borderColor, Point theCenter, Color fillColor, int side) {
        super(borderColor, theCenter, fillColor);
        this.side = side;
    }

    public Square(Color borderColor, Point theCenter, Color fillColor, Point anotherPoint) {
        super(borderColor, theCenter, fillColor);
        addPoint(anotherPoint);
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public void addPoint(Point point) {
        side = 2 * Util.maxPerpendDistance(getTheCenter(), point);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setStroke(getStroke());
        g2d.setColor(getFillColor());
        g2d.fillRect(getTheCenter().x - side / 2, getTheCenter().y - side / 2, side, side);
        g2d.setColor(getBorderColor());
        g2d.drawRect(getTheCenter().x - side / 2, getTheCenter().y - side / 2, side, side);
    }
}
