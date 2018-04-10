package pl.randomwalk.drawpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.ThreadLocalRandom;

import pl.randomwalk.custompoint.CustomPoint;
import pl.randomwalk.custompoint.Preferences;

public class DrawPanelListener implements ComponentListener, MouseMotionListener, MouseListener {

	DrawPanel drawPanel;

	public DrawPanelListener(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
		this.drawPanel.addMouseListener(this);
		this.drawPanel.addComponentListener(this);
		this.drawPanel.addMouseMotionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int score = ThreadLocalRandom.current().nextInt(0, 4);
		switch (score) {
		case 0:
			Preferences.setPOINT_COLOR(Color.BLUE);
			break;
		case 1:
			Preferences.setPOINT_COLOR(Color.YELLOW);
			break;
		case 2:
			Preferences.setPOINT_COLOR(Color.RED);
			break;
		case 3:
			Preferences.setPOINT_COLOR(Color.GREEN);
			break;
		default:
			break;
		}
		System.out.println(Preferences.getPOINT_COLOR());
		drawPanel.addPoint(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		drawPanel.addPoint(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void componentResized(ComponentEvent e) {
		drawPanel.setBoardSize(new Dimension(drawPanel.getWidth() / Preferences.BLOCK_SIZE - 2,
				drawPanel.getHeight() / Preferences.BLOCK_SIZE - 2));
		drawPanel.updateArraySize();
	}

	@Override
	public void componentMoved(ComponentEvent e) {

	}

	@Override
	public void componentShown(ComponentEvent e) {
	}

	@Override
	public void componentHidden(ComponentEvent e) {

	}

}
