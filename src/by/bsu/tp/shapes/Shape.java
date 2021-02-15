package by.bsu.tp.shapes;

import java.awt.*;

public abstract class Shape {
    private Color borderColor;
    private Point theCenter;

    public Shape(Color borderColor, Point theCenter) {
        this.borderColor = borderColor;
        this.theCenter = theCenter;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public abstract void draw();

    public void move(Point newCenter) {
        this.theCenter = newCenter;
    }

    public abstract Point location();

    public Point getTheCenter() {
        return theCenter;
    }

    public void setTheCenter(Point theCenter) {
        this.theCenter = theCenter;
    }
}
