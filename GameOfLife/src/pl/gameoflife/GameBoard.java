package pl.gameoflife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements Runnable {

	private static final long serialVersionUID = 4074997690549421757L;
	public Dimension gameBoardSize = null;
	private List<Point> point;
	public static int BLOCK_SIZE = 15;
	public static int TIME_PERIOD = 5;
	public static int CURRENT_SHIP = NamesOfShipsAndOscillators.POINT;

	public GameBoard() {
		point = new ArrayList<>();
		this.setBackground(Color.BLACK);
	}

	public void updateArraySize() {
		List<Point> removeList = new ArrayList<>(0);
		for (Point current : point) {
			if ((current.x > gameBoardSize.width - 1) || (current.y > gameBoardSize.height - 1)) {
				removeList.add(current);
			}
		}
		point.removeAll(removeList);
		repaint();
	}

	public void addPoint(int x, int y) {
		if (!point.contains(new Point(x, y))) {
			point.add(new Point(x, y));
		}
		repaint();
	}

	public void addPoint(MouseEvent e) {
		int x = e.getPoint().x / BLOCK_SIZE - 1;
		int y = e.getPoint().y / BLOCK_SIZE - 1;
		if ((x >= 0) && (x < gameBoardSize.width) && (y >= 0) && (y < gameBoardSize.height)) {
			addPoint(x, y);
		}
	}

	public void removePoint(int x, int y) {
		point.remove(new Point(x, y));
	}

	public void resetBoard() {
		point.clear();
	}

	public void randomlyFillBoard(int percent) {
		for (int i = 0; i < gameBoardSize.width; i++) {
			for (int j = 0; j < gameBoardSize.height; j++) {
				if (Math.random() * 100 < percent) {
					addPoint(i, j);
				}
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			for (Point newPoint : point) {
				g.setColor(Color.RED);
				g.fillRect(BLOCK_SIZE + (BLOCK_SIZE * newPoint.x), BLOCK_SIZE + (BLOCK_SIZE * newPoint.y), BLOCK_SIZE,
						BLOCK_SIZE);
			}
		} catch (ConcurrentModificationException ex) {
		}
		g.setColor(Color.DARK_GRAY);
		for (int i = 0; i <= gameBoardSize.width; i++) {
			g.drawLine((i * BLOCK_SIZE) + BLOCK_SIZE, BLOCK_SIZE, (i * BLOCK_SIZE) + BLOCK_SIZE,
					BLOCK_SIZE + (BLOCK_SIZE * gameBoardSize.height));
		}
		for (int i = 0; i <= gameBoardSize.height; i++) {
			g.drawLine(BLOCK_SIZE, (i * BLOCK_SIZE) + BLOCK_SIZE, BLOCK_SIZE * (gameBoardSize.width + 1),
					((i * BLOCK_SIZE) + BLOCK_SIZE));
		}
	}

	public Dimension getGameBoardSize() {
		return gameBoardSize;
	}

	public void setGameBoardSize(Dimension gameBoardSize) {
		this.gameBoardSize = gameBoardSize;
	}

	@Override
	public void run() {
		boolean[][] gameBoard = new boolean[gameBoardSize.width + 2][gameBoardSize.height + 2];
		for (Point current : point) {
			gameBoard[current.x + 1][current.y + 1] = true;
		}
		List<Point> survivingCells = new ArrayList<>(0);
		for (int i = 1; i < gameBoard.length - 1; i++) {
			for (int j = 1; j < gameBoard[0].length - 1; j++) {
				int surrounding = 0;
				if (gameBoard[i - 1][j - 1]) {
					surrounding++;
				}
				if (gameBoard[i - 1][j]) {
					surrounding++;
				}
				if (gameBoard[i - 1][j + 1]) {
					surrounding++;
				}
				if (gameBoard[i][j - 1]) {
					surrounding++;
				}
				if (gameBoard[i][j + 1]) {
					surrounding++;
				}
				if (gameBoard[i + 1][j - 1]) {
					surrounding++;
				}
				if (gameBoard[i + 1][j]) {
					surrounding++;
				}
				if (gameBoard[i + 1][j + 1]) {
					surrounding++;
				}
				if (gameBoard[i][j]) {
					if ((surrounding == 2) || (surrounding == 3)) {
						survivingCells.add(new Point(i - 1, j - 1));
					}
				} else {
					if (surrounding == 3) {
						survivingCells.add(new Point(i - 1, j - 1));
					}
				}

			}
		}
		resetBoard();
		point.addAll(survivingCells);
		repaint();
		try {
			Thread.sleep(1000 / TIME_PERIOD);
			run();
		} catch (InterruptedException ex) {
			// System.out.println(ex.getMessage());
		}
	}

	// Ships
	public void glider(MouseEvent e) {
		int x = e.getPoint().x / BLOCK_SIZE - 1;
		int y = e.getPoint().y / BLOCK_SIZE - 1;
		if ((x >= 0) && (x < gameBoardSize.width) && (y >= 0) && (y < gameBoardSize.height)) {
			addPoint(x, y);
			addPoint(x + 1, y);
			addPoint(x + 2, y);
			addPoint(x, y + 1);
			addPoint(x + 1, y + 2);
		}
	}

	public void lightweightSpaceship(MouseEvent e) {
		int x = e.getPoint().x / BLOCK_SIZE - 1;
		int y = e.getPoint().y / BLOCK_SIZE - 1;
		if ((x >= 0) && (x < gameBoardSize.width) && (y >= 0) && (y < gameBoardSize.height)) {
			addPoint(x, y);
			addPoint(x + 1, y);
			addPoint(x + 2, y);
			addPoint(x + 3, y);
			addPoint(x + 4, y + 1);
			addPoint(x + 4, y + 3);
			addPoint(x, y + 1);
			addPoint(x, y + 2);
			addPoint(x + 1, y + 3);
		}
	}

	// Oscillators
	public void caterer(MouseEvent e) {
		int x = e.getPoint().x / BLOCK_SIZE - 1;
		int y = e.getPoint().y / BLOCK_SIZE - 1;
		if ((x >= 0) && (x < gameBoardSize.width) && (y >= 0) && (y < gameBoardSize.height)) {
			addPoint(x + 2, y);
			addPoint(x, y + 1);
			addPoint(x, y + 2);
			addPoint(x, y + 3);
			addPoint(x + 1, y + 5);
			addPoint(x + 2, y + 5);
			addPoint(x + 3, y + 4);
			addPoint(x + 4, y + 2);
			addPoint(x + 4, y + 1);
			addPoint(x + 5, y + 1);
			addPoint(x + 6, y + 1);
			addPoint(x + 7, y + 1);

		}
	}

	public void figureEight(MouseEvent e) {
		int x = e.getPoint().x / BLOCK_SIZE - 1;
		int y = e.getPoint().y / BLOCK_SIZE - 1;
		if ((x >= 0) && (x < gameBoardSize.width) && (y >= 0) && (y < gameBoardSize.height)) {
			for (int i = 0; i < 3; i++) {
				addPoint(x + i, y);
				addPoint(x, y + i);
				addPoint(x + i, y + i);
				addPoint(x + i + 3, y + 3);
				addPoint(x + 3, y + i + 3);
				addPoint(x + i + 3, y + i + 3);
			}
			addPoint(x + 2, y + 1);
			addPoint(x + 1, y + 2);
			addPoint(x + 4, y + 5);
			addPoint(x + 5, y + 4);

		}
	}

}
