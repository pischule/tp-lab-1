package by.bsu.tp.shapes;

import by.bsu.tp.Util;

import java.awt.*;

public class Square extends Shape2D{
    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    private int side;

    public Square(Color borderColor, Point theCenter, Color fillColor) {
        super(borderColor, theCenter, fillColor);
    }

    @Override
    public void setAnotherPoint(Point point) {
        side = 2 * Util.perpendicularDistance(getTheCenter(), point);
    }

    @Override
    public void draw(Graphics2D g2d) {

    }
}
