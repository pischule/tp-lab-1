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

    public Square(Color borderColor, Point theCenter, Color fillColor, int side) {
        super(borderColor, theCenter, fillColor);
        this.side = side;
    }

    public Square(Color borderColor, Point theCenter, Color fillColor, Point anotherPoint) {
        super(borderColor, theCenter, fillColor);
        setAnotherPoint(anotherPoint);
    }


    @Override
    public void setAnotherPoint(Point point) {
        side = 2 * Util.perpendicularDistance(getTheCenter(), point);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.fillRect(getTheCenter().x-side/2, getTheCenter().y-side/2, side, side);
    }
}
