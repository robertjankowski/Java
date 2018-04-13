package pl.java.lab5;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import pl.java.lab5.shapes.Circle;
import pl.java.lab5.shapes.Line;
import pl.java.lab5.shapes.Rectangle;
import pl.java.lab5.shapes.Rubber;
import pl.java.lab5.shapes.StraightLine;
import pl.java.lab5.shapes.ToolsName;

public class DrawPanelListener implements MouseMotionListener, MouseListener {

	DrawPanel drawPanel;
	BottomPanel bottomPanel;
	FloodFill fill;
	Robot robot;
	boolean isFill = false;

	public DrawPanelListener(DrawPanel drawPanel, BottomPanel bottomPanel) {
		this.drawPanel = drawPanel;
		this.bottomPanel = bottomPanel;
		drawPanel.addMouseListener(this);
		drawPanel.addMouseMotionListener(this);
		fill = new FloodFill(drawPanel, this);
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(robot.getPixelColor(e.getX(), e.getY()));
		switch (bottomPanel.label.getText()) {
		case ToolsName.PENCIL:
			drawPanel.shape = new Line();
			break;
		case ToolsName.LINE:
			drawPanel.shape = new StraightLine();
			break;
		case ToolsName.CIRCLE:
			drawPanel.shape = new Circle();
			break;
		case ToolsName.RECTANGLE:
			drawPanel.shape = new Rectangle();
			break;
		case ToolsName.RUBBER:
			drawPanel.shape = new Rubber(drawPanel);
			break;
		case ToolsName.FILL:
			fill.paintBucket(e.getX(), e.getY(), robot.getPixelColor(e.getX(), e.getY()));
			isFill = true;
			break;
		default:
			System.out.println("There is no such tool like" + bottomPanel.label.getText());
		}
		if (!isFill) {
			drawPanel.shape.addPoint(e.getX(), e.getY());
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (!isFill) {
			drawPanel.shape.update(e.getX(), e.getY());
			drawPanel.repaint();
		}
		if (isFill) {
			fill.pencil(e.getX(), e.getY());
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (!isFill) {
			drawPanel.shapes.add(drawPanel.shape);
			drawPanel.shape = null;
			drawPanel.repaint();
		}
		if(isFill) {
			isFill = false;
		}

	}

	public Color getColor(int x, int y) {
		return robot.getPixelColor(x, y);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}
