package by.bsu.tp.shapes;

import java.awt.*;

public abstract class Shape1D extends Shape2D{
    private Point p;

    public Shape1D(Color borderColor, Point theCenter, Color fillColor, Point p) {
        super(borderColor, theCenter, fillColor);
        this.p = p;
    }

    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }
}
