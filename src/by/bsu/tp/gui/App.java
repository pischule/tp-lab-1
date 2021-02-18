package by.bsu.tp.gui;

import by.bsu.tp.config.Config;
import by.bsu.tp.shapes.Rectangle;
import by.bsu.tp.shapes.Shape;
import by.bsu.tp.shapes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;


class JIconComboBox extends JComboBox<Icon> {
}

public class App extends JFrame {
    private JToggleButton rectangleButton, ellipseButton, regularPolygonButton, segmentButton,
            lineButton, rayButton, polygonButton, parallelogramButton, rhombButton;
    private JToggleButton moveShapesButton;
    private JPanel rootPanel;
    private JPanel drawPanel;
    private JButton circleButton;
    private final RegularPolygonDialog sideNumDialog;
    private final ArrayList<Shape> shapes = new ArrayList<>();
    private boolean isDragged = false;
    private Tool currentTool;

    private final Color borderColor;
    private final Color fillColor;

    public App() {
        super(Config.APP_NAME);
        sideNumDialog = new RegularPolygonDialog(this);
        $$$setupUI$$$();
        setContentPane(rootPanel);
        addActionListeners();
        setSize(Config.WINDOW_SIZE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        fillColor = Config.DEFAULT_FILL_COLOR;
        borderColor = Config.DEFAULT_FRAME_COLOR;
        currentTool = Tool.NONE;

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }

    private void addActionListeners() {
        rhombButton.addActionListener(e -> currentTool = Tool.RHOMB);
        polygonButton.addActionListener(e -> currentTool = Tool.POLYGON);
        lineButton.addActionListener(e -> currentTool = Tool.LINE);
        rayButton.addActionListener(e -> currentTool = Tool.RAY);
        segmentButton.addActionListener(e -> currentTool = Tool.SEGMENT);
        circleButton.addActionListener(e -> currentTool = Tool.CIRCLE);
        regularPolygonButton.addActionListener(e -> {
            currentTool = Tool.REGULAR_POLYGON;
            sideNumDialog.showDialog();
        });
        rectangleButton.addActionListener(e -> currentTool = Tool.RECTANGLE);
        ellipseButton.addActionListener(e -> currentTool = Tool.ELLIPSE);
        moveShapesButton.addActionListener(e -> currentTool = Tool.MOVE);

        drawPanel.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                whenMousePressed(e.getPoint());
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                whenMouseReleased(e.getPoint());
                isDragged = false;
                repaint();
            }

        });

        drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                whenMouseDragged(e.getPoint());
                repaint();
            }
        });

    }

    private void whenMousePressed(Point p) {
        switch (currentTool) {
            case MOVE -> shapes.stream()
                    .filter(x -> x.containsPoint(p))
                    .findFirst()
                    .ifPresent(x -> {
                        shapes.remove(x);
                        shapes.add(x);
                        isDragged = true;
                    });
            case RECTANGLE -> shapes.add(new Rectangle(borderColor, p, fillColor, p));
            case ELLIPSE -> shapes.add(new Ellipse(borderColor, p, fillColor, p));
            case SQUARE -> shapes.add(new Square(borderColor, p, fillColor, p));
            case CIRCLE -> shapes.add(new Circle(borderColor, p, fillColor, p));
            case RAY -> shapes.add(new Ray(borderColor, p, fillColor, p));
            case LINE -> shapes.add(new Line(borderColor, p, fillColor, p));
            case RHOMB -> shapes.add(new Rhomb(borderColor, p, fillColor, p));
            case REGULAR_POLYGON -> shapes.add(new RegularPolygon(borderColor, p, fillColor, p, 5));
            case SEGMENT -> shapes.add(new Segment(borderColor, p, fillColor, p));
        }

    }

    private void whenMouseReleased(Point p) {
        currentTool = Tool.MOVE;
    }

    private void whenMouseDragged(Point p) {
        if (shapes == null || shapes.size() == 0) return;
        Shape lastShape = shapes.get(shapes.size() - 1);
        if (Tool.MOVE.equals(currentTool) && isDragged) {
            lastShape.move(p);
        } else if (Tool.NONE.equals(currentTool)) {

        } else {
            lastShape.setAnotherPoint(p);
        }
        System.out.println("current tool=" + currentTool);
    }

    private void createUIComponents() {
        drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                for (Shape s : shapes)
                    s.draw(g2d);
            }
        };
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout(0, 0));
        final JToolBar toolBar1 = new JToolBar();
        toolBar1.setFloatable(false);
        rootPanel.add(toolBar1, BorderLayout.NORTH);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel1.setInheritsPopupMenu(true);
        panel1.setMaximumSize(new Dimension(200, 2147483647));
        toolBar1.add(panel1);
        rectangleButton = new JToggleButton();
        rectangleButton.setText("Rect");
        panel1.add(rectangleButton);
        circleButton = new JButton();
        circleButton.setText("Circle");
        panel1.add(circleButton);
        rayButton = new JToggleButton();
        rayButton.setText("Ray");
        panel1.add(rayButton);
        regularPolygonButton = new JToggleButton();
        regularPolygonButton.setText("Regular Polygon");
        panel1.add(regularPolygonButton);
        ellipseButton = new JToggleButton();
        ellipseButton.setAlignmentX(0.5f);
        ellipseButton.setHideActionText(false);
        ellipseButton.setIconTextGap(4);
        ellipseButton.setText("Ellipse");
        panel1.add(ellipseButton);
        segmentButton = new JToggleButton();
        segmentButton.setText("Segment");
        panel1.add(segmentButton);
        lineButton = new JToggleButton();
        lineButton.setText("Line");
        panel1.add(lineButton);
        polygonButton = new JToggleButton();
        polygonButton.setText("Polygon");
        panel1.add(polygonButton);
        parallelogramButton = new JToggleButton();
        parallelogramButton.setText("Parallelogram");
        panel1.add(parallelogramButton);
        rhombButton = new JToggleButton();
        rhombButton.setText("Rhomb");
        panel1.add(rhombButton);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        toolBar1.add(panel2);
        moveShapesButton = new JToggleButton();
        moveShapesButton.setText("move");
        panel2.add(moveShapesButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        rootPanel.add(drawPanel, BorderLayout.CENTER);
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(ellipseButton);
        buttonGroup.add(regularPolygonButton);
        buttonGroup.add(segmentButton);
        buttonGroup.add(rayButton);
        buttonGroup.add(lineButton);
        buttonGroup.add(polygonButton);
        buttonGroup.add(rhombButton);
        buttonGroup.add(parallelogramButton);
        buttonGroup.add(rectangleButton);
        buttonGroup.add(moveShapesButton);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

}

