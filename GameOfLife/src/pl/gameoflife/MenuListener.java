package pl.gameoflife;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JOptionPane;

public class MenuListener implements ActionListener {

	MenuBar menuBar;
	GameBoard gameBoard;
	Thread game;

	public MenuListener(MenuBar menuBar, GameBoard gameBoard) {
		this.menuBar = menuBar;
		this.gameBoard = gameBoard;
		menuBar.file_exit.addActionListener(this);
		menuBar.file_options.addActionListener(this);
		menuBar.game_autofill.addActionListener(this);
		menuBar.game_play.addActionListener(this);
		menuBar.game_reset.addActionListener(this);
		menuBar.game_stop.addActionListener(this);
		menuBar.help_about.addActionListener(this);
		menuBar.help_source.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src.equals(menuBar.file_exit)) {
			System.exit(0);
		}
		if (src.equals(menuBar.file_options)) {
			new TimePeriodFrame(gameBoard);
		}
		if (src.equals(menuBar.game_autofill)) {
			new AutofillFrame(gameBoard);
		}
		if (src.equals(menuBar.game_play)) {
			setGameBeingPlayed(true);
		}
		if (src.equals(menuBar.game_reset)) {
			gameBoard.resetBoard();
			gameBoard.repaint();
		}
		if (src.equals(menuBar.game_stop)) {
			setGameBeingPlayed(false);
		}
		if (src.equals(menuBar.help_about)) {
			JOptionPane.showMessageDialog(null,
					"The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970.");
		}
		if (src.equals(menuBar.help_source)) {
			Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
			try {
				desktop.browse(new URI("https://github.com/javaProjekty/lab/tree/master/GameOfLife"));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Source is not available");
			}
		}
	}

	public void setGameBeingPlayed(boolean isBeingPlayed) {
		if (isBeingPlayed) {
			menuBar.game_play.setEnabled(false);
			menuBar.game_stop.setEnabled(true);
			game = new Thread(gameBoard);
			game.start();
		}
		if (!isBeingPlayed) {
			menuBar.game_play.setEnabled(true);
			menuBar.game_stop.setEnabled(false);
			game.interrupt();
		}
	}

}
