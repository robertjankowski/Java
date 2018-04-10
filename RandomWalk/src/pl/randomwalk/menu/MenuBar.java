package pl.randomwalk.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

	JMenu simulation;
	JMenu time;
	JMenu timeOptions;

	JMenuItem start;
	JMenuItem stop;
	JMenuItem timeSlow;
	JMenuItem timeNormal;
	JMenuItem timeFast;

	public MenuBar() {
		simulation = new JMenu("Simulation");
		time = new JMenu("Time");
		timeOptions = new JMenu("Options");

		start = new JMenuItem("Start");
		stop = new JMenuItem("Stop");
		timeSlow = new JMenuItem("Slow");
		timeNormal = new JMenuItem("Regular");
		timeFast = new JMenuItem("Fast");

		simulation.add(start);
		simulation.addSeparator();
		simulation.add(stop);
		time.add(timeOptions);
		timeOptions.add(timeSlow);
		timeOptions.addSeparator();
		timeOptions.add(timeNormal);
		timeOptions.addSeparator();
		timeOptions.add(timeFast);

		this.add(simulation);
		this.add(time);
	}

}
