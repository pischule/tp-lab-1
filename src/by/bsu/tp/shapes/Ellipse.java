package by.bsu.tp.shapes;

import java.awt.*;

public class Ellipse extends RectangleShape {
    public Ellipse(Color borderColor, Point theCenter, Color fillColor, int width, int height) {
        super(borderColor, theCenter, fillColor, width, height);
    }

    public Ellipse(Color borderColor, Point theCenter, Color fillColor, Point antherPoint) {
        super(borderColor, theCenter, fillColor, antherPoint);
    }

    @Override
    public void draw(Graphics2D g2d) {

    }

    @Override
    public Point location() {
        return null;
    }
}
