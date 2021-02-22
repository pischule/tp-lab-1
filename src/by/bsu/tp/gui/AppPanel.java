package by.bsu.tp.gui;

import by.bsu.tp.config.Config;
import by.bsu.tp.shapes.Polygon;
import by.bsu.tp.shapes.Rectangle;
import by.bsu.tp.shapes.Shape;
import by.bsu.tp.shapes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class AppPanel extends JPanel {

    private final ArrayList<Shape> shapes = new ArrayList<>();
    private JPanel drawPanel;
    private JPanel buttonsPanel;
    private boolean isDragged = false;
    private Tool currentTool;

    private Color borderColor;
    private Color fillColor;

    private boolean drawingPolygon;

    private int numberOfPoints;

    private static int LEFT_MOUSE_BUTTON = 1;

    public AppPanel() {
        super();
        createUIComponents();

        addActionListeners();

        fillColor = Config.DEFAULT_FILL_COLOR;
        borderColor = Config.DEFAULT_FRAME_COLOR;
        currentTool = Tool.MOVE;
        drawingPolygon = false;
    }

    private void addActionListeners() {

        drawPanel.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                whenMousePressed(e.getPoint(), e.getButton());
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                whenMouseReleased(e.getPoint());
            }
        });

        drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                whenMouseDragged(e.getPoint());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                whenMouseMoved(e.getPoint());
            }

        });
    }

    private void whenMouseMoved(Point point) {
        if (Tool.POLYGON.equals(currentTool) && drawingPolygon) {
            Polygon polygon = (Polygon) shapes.get(shapes.size()-1);
            polygon.updateLastPoint(point);
            drawPanel.updateUI();
        }
    }

    private void whenMousePressed(Point p, int mouseButton) {

        switch (currentTool) {
            case MOVE -> shapes.stream()
                    .filter(x -> x.containsPoint(p))
                    .findFirst()
                    .ifPresent(x -> {
                        shapes.remove(x);
                        shapes.add(x);
                        isDragged = true;
                    });
            case POLYGON -> {
                if (!drawingPolygon) {
                    shapes.add(new Polygon(borderColor, p, fillColor, p));
                    drawingPolygon = true;
                } else {
                    Polygon polygon = (Polygon) shapes.get(shapes.size()-1);
                    polygon.addPoint(p);
                    if (mouseButton != LEFT_MOUSE_BUTTON) {
                        drawingPolygon = false;
                        currentTool = Tool.MOVE;
                    }
                }
            }
            case RECTANGLE -> shapes.add(new Rectangle(borderColor, p, fillColor, p));
            case ELLIPSE -> shapes.add(new Ellipse(borderColor, p, fillColor, p));
            case CIRCLE -> shapes.add(new Circle(borderColor, p, fillColor, p));
            case SEGMENT -> shapes.add(new Segment(borderColor, p, fillColor, p));
            case TRIANGLE -> shapes.add(new Triangle(borderColor, p, fillColor, p));
            case LINE -> shapes.add(new Line(borderColor, p, fillColor, p));
            case RAY -> shapes.add(new Ray(borderColor, p, fillColor, p));
            case RHOMBUS -> shapes.add(new Rhombus(borderColor, p, fillColor, p));
            case REGULAR_POLYGON -> shapes.add(new RegularPolygon(borderColor, p, fillColor, p, numberOfPoints));
        }
        repaint();
    }

    private void whenMouseReleased(Point p) {
        if (!drawingPolygon) {
            isDragged = false;
            currentTool = Tool.MOVE;
        }
    }

    private void whenMouseDragged(Point p) {
        if (shapes == null || shapes.size() == 0) return;
        Shape lastShape = shapes.get(shapes.size() - 1);
        if (Tool.MOVE.equals(currentTool) && isDragged) {
            lastShape.move(p);
        } else if (!Tool.MOVE.equals(currentTool)) {
            lastShape.updateLastPoint(p);
        }
        repaint();
    }

    private void createUIComponents() {
        setSize(Config.WINDOW_SIZE);
        setLayout(new BorderLayout());
        // create frame

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(0, 1));

        fillColor = Color.GRAY;
        borderColor = Color.BLACK;

        Arrays.stream(Tool.values())
                .filter(x -> !x.equals(Tool.REGULAR_POLYGON))
                .map(x -> {
                    JButton button = new JButton(x.getName());
                    button.addActionListener((e) -> currentTool = x);
                    return button;
                }).forEach(x -> buttonsPanel.add(x));

        JButton polygonButton = new JButton();
        polygonButton.setText(Tool.REGULAR_POLYGON.getName());
        polygonButton.addActionListener(e -> {
            currentTool = Tool.REGULAR_POLYGON;
            String userInput = JOptionPane.showInputDialog("Input number of vertices: ");
            int n = Integer.parseInt(userInput);
            numberOfPoints = Optional.of(Integer.parseInt(userInput))
                    .filter(x -> x > 1)
                    .orElseGet(() -> {
                        JOptionPane.showMessageDialog(this, "Bad argument");
                        return numberOfPoints;
                    });
        });
        buttonsPanel.add(polygonButton);

        JButton fillColorButton = new JButton();
        fillColorButton.setText("Fill Color");
        fillColorButton.addActionListener((e) -> fillColor = JColorChooser.showDialog(null, "Choose fill color", fillColor));
        buttonsPanel.add(fillColorButton);

        JButton borderColorButton = new JButton();
        borderColorButton.setText("Border Color");
        borderColorButton.addActionListener((e) -> borderColor = JColorChooser.showDialog(null, "Choose border color", borderColor));
        buttonsPanel.add(borderColorButton);

        JButton clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.addActionListener(e -> {
            shapes.clear();
            drawPanel.updateUI();
        });
        buttonsPanel.add(clearButton);

        drawPanel = new DrawingPanel(shapes);

        add(buttonsPanel, BorderLayout.WEST);
        add(drawPanel, BorderLayout.CENTER);
    }
}
