package pl.gameoflife;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameBoardListener implements ComponentListener, MouseListener, MouseMotionListener {

	GameBoard gameBoard;

	public GameBoardListener(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
		this.gameBoard.addMouseListener(this);
		this.gameBoard.addMouseMotionListener(this);
		this.gameBoard.addComponentListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		switch (GameBoard.CURRENT_SHIP) {
		case NamesOfShipsAndOscillators.POINT:
			gameBoard.addPoint(e);
			break;
		case NamesOfShipsAndOscillators.GLIDER:
			gameBoard.glider(e);
			break;
		case NamesOfShipsAndOscillators.LIGHTWEIGHT_SPACESHIP:
			gameBoard.lightweightSpaceship(e);
			break;
		case NamesOfShipsAndOscillators.CATERER:
			gameBoard.caterer(e);
			break;
		case NamesOfShipsAndOscillators.FIGURE_EIGHT:
			gameBoard.figureEight(e);
			break;
		default:
			System.out.println("There is not such ship or oscillator");
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch (GameBoard.CURRENT_SHIP) {
		case NamesOfShipsAndOscillators.POINT:
			gameBoard.addPoint(e);
			break;
		case NamesOfShipsAndOscillators.GLIDER:
			gameBoard.glider(e);
			break;
		case NamesOfShipsAndOscillators.LIGHTWEIGHT_SPACESHIP:
			gameBoard.lightweightSpaceship(e);
			break;
		case NamesOfShipsAndOscillators.CATERER:
			gameBoard.caterer(e);
			break;
		case NamesOfShipsAndOscillators.FIGURE_EIGHT:
			gameBoard.figureEight(e);
			break;
		default:
			System.out.println("There is not such ship or oscillator");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void componentResized(ComponentEvent e) {
		gameBoard.setGameBoardSize(new Dimension(gameBoard.getWidth() / GameBoard.BLOCK_SIZE - 2,
				gameBoard.getHeight() / GameBoard.BLOCK_SIZE - 2));
		gameBoard.updateArraySize();
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
