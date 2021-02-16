package by.bsu.tp.shapes;

import java.awt.*;
import java.util.ArrayList;

public class Polygon extends Shape2D{
    private ArrayList<Point> points;

    public Polygon(Color borderColor, Point theCenter, Color fillColor, ArrayList<Point> points) {
        super(borderColor, theCenter, fillColor);
        this.points = points;
    }

    @Override
    public void setAnotherPoint(Point point) {
        points.add(point);
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public void draw(Graphics2D g2d) {

    }
}
