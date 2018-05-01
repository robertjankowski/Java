package pl.gameoflife;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 8226552154769201507L;
	JMenu file;
	JMenu game;
	JMenu help;

	JMenuItem file_options;
	JMenuItem file_exit;

	JMenuItem game_autofill;
	JMenuItem game_play;
	JMenuItem game_stop;
	JMenuItem game_reset;

	JMenuItem help_about;
	JMenuItem help_source;

	public MenuBar() {
		file = new JMenu("File");
		game = new JMenu("Game");
		help = new JMenu("Help");

		file_options = new JMenuItem("Time options");
		file_exit = new JMenuItem("Exit");

		game_autofill = new JMenuItem("Autofill");
		game_play = new JMenuItem("Play");
		game_stop = new JMenuItem("Stop");
		game_reset = new JMenuItem("Reset");

		help_about = new JMenuItem("About");
		help_source = new JMenuItem("Source");

		file.add(file_options);
		file.addSeparator();
		file.add(file_exit);
		game.add(game_autofill);
		game.addSeparator();
		game.add(game_play);
		game.addSeparator();
		game.add(game_stop);
		game.addSeparator();
		game.add(game_reset);
		help.add(help_about);
		help.addSeparator();
		help.add(help_source);

		this.add(file);
		this.add(game);
		this.add(help);
	}

}
