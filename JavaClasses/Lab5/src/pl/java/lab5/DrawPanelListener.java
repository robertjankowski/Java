package pl.java.lab5;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

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
	boolean isFill = false;

	public DrawPanelListener(DrawPanel drawPanel, BottomPanel bottomPanel) {
		this.drawPanel = drawPanel;
		this.bottomPanel = bottomPanel;
		drawPanel.addMouseListener(this);
		drawPanel.addMouseMotionListener(this);
		fill = new FloodFill(drawPanel, this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
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
			// do poprawy !
			fill.paintBucket(e.getX(), e.getY(), Constants.bgColor, Color.GREEN);
			System.out.println("Color "+Constants.bgColor);
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
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (!isFill) {
			drawPanel.shapes.add(drawPanel.shape);
			drawPanel.shape = null;
			drawPanel.repaint();
		}
		if (isFill) {
			isFill = false;
		}

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
