package by.bsu.tp.shapes;

import java.awt.*;

public class Rectangle extends RectangleShape {

    public Rectangle(Color borderColor, Point theCenter, Color fillColor, int width, int height) {
        super(borderColor, theCenter, fillColor, width, height);
    }

    public Rectangle(Color borderColor, Point theCenter, Color fillColor, Point antherPoint) {
        super(borderColor, theCenter, fillColor, antherPoint);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.fillRect(getTheCenter().x - getWidth()/2, getTheCenter().y - getHeight()/2, getWidth(), getHeight());
    }
}
