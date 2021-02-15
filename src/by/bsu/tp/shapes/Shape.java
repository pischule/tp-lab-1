package by.bsu.tp.shapes;

import java.awt.*;

public class Shape {
    public Shape(Point theCenter) {
        this.theCenter = theCenter;
    }

    private Point theCenter;

    public Point getTheCenter() {
        return theCenter;
    }

    public void setTheCenter(Point theCenter) {
        this.theCenter = theCenter;
    }
}
