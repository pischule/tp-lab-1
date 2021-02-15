package by.bsu.tp.shapes;

import java.awt.*;

public class Ellipse extends RectangleShape {
    public Ellipse(Color borderColor, Point theCenter, Color fillColor) {
        super(borderColor, theCenter, fillColor);
    }

    @Override
    public void draw(Graphics2D g2d) {

    }

    @Override
    public Point location() {
        return null;
    }
}
