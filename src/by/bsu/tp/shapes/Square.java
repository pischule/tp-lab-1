package by.bsu.tp.shapes;

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
    public void draw() {

    }
}
