package pl.randomwalk.drawpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;

import pl.randomwalk.Chart;
import pl.randomwalk.custompoint.CustomPoint;
import pl.randomwalk.custompoint.Preferences;

public class DrawPanel extends JPanel implements Runnable {

	public Dimension boardSize = null;
	private List<CustomPoint> point;
	public static int TIME_PERIOD = 10;
	Chart chart;

	public DrawPanel(Chart chart) {
		point = new ArrayList<>();
		this.setBackground(Color.WHITE);
		this.chart = chart;
	}

	public void updateArraySize() {
		List<Point> removeList = new ArrayList<>(0);
		for (Point current : point) {
			if ((current.x > boardSize.width - 1) || (current.y > boardSize.height - 1)) {
				removeList.add(current);
			}
		}
		point.removeAll(removeList);
		repaint();
	}

	public void addPoint(int x, int y) {
		if (!point.contains(new CustomPoint(x, y))) {
			point.add(new CustomPoint(x, y));
		}
		repaint();
	}

	public void addPoint(MouseEvent e) {
		int x = e.getPoint().x / Preferences.BLOCK_SIZE - 1;
		int y = e.getPoint().y / Preferences.BLOCK_SIZE - 1;
		if ((x >= 0) && (x < boardSize.width) && (y >= 0) && (y < boardSize.height)) {
			addPoint(x, y);
		}
	}

	public void removePoint(int x, int y) {
		point.remove(new Point(x, y));
	}

	public void resetBoard() {
		point.clear();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			for (CustomPoint newPoint : point) {
				newPoint.draw(g);
			}
		} catch (ConcurrentModificationException ex) {
		}
		g.setColor(Color.WHITE);
		for (int i = 0; i <= boardSize.width; i++) {
			g.drawLine((i * Preferences.BLOCK_SIZE) + Preferences.BLOCK_SIZE, Preferences.BLOCK_SIZE,
					(i * Preferences.BLOCK_SIZE) + Preferences.BLOCK_SIZE,
					Preferences.BLOCK_SIZE + (Preferences.BLOCK_SIZE * boardSize.height));
		}
		for (int i = 0; i <= boardSize.height; i++) {
			g.drawLine(Preferences.BLOCK_SIZE, (i * Preferences.BLOCK_SIZE) + Preferences.BLOCK_SIZE,
					Preferences.BLOCK_SIZE * (boardSize.width + 1),
					((i * Preferences.BLOCK_SIZE) + Preferences.BLOCK_SIZE));
		}
	}

	public void setBoardSize(Dimension boardSize) {
		this.boardSize = boardSize;
	}

	@Override
	public void run() {
		chart.addToChart(Preferences.UP, Preferences.DOWN);
		boolean[][] board = new boolean[boardSize.width + 2][boardSize.height + 2];
		for (Point current : point) {
			board[current.x + 1][current.y + 1] = true;
		}
		int tmpUP = Preferences.UP;
		int tmpDOWN = Preferences.DOWN;
		List<CustomPoint> cells = new ArrayList<>(0);
		for (int i = 1; i < board.length - 1; i++) {
			for (int j = 1; j < board[0].length - 1; j++) {
				if (board[i][j]) {
					// randomly add new Point
					int score = ThreadLocalRandom.current().nextInt(0, 4);
					switch (score) {
					case 0:
						cells.add(new CustomPoint(i, j - 1));
						Preferences.UP++;
						break;
					case 1:
						cells.add(new CustomPoint(i - 1, j));
						break;
					case 2:
						cells.add(new CustomPoint(i - 2, j - 1));
						Preferences.DOWN++;
						break;
					case 3:
						cells.add(new CustomPoint(i - 1, j - 2));
						break;
					default:
						break;
					}
				}
			}
		}
		resetBoard();
		point.addAll(cells);
		repaint();
		Toolkit.getDefaultToolkit().sync();
		try {
			Thread.sleep(1000 / TIME_PERIOD);
			run();
		} catch (InterruptedException ex) {
			// System.out.println(ex.getMessage());
		}

		// wykres do poprawy !

	}
}
