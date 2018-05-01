package pl.randomwalk.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.randomwalk.Chart;
import pl.randomwalk.custompoint.Preferences;
import pl.randomwalk.drawpanel.DrawPanel;

public class MenuBarListener implements ActionListener {

	MenuBar menuBar;
	DrawPanel drawPanel;
	Thread game;
	Chart chart;

	public MenuBarListener(MenuBar menuBar, DrawPanel drawPanel, Chart chart) {
		this.menuBar = menuBar;
		this.drawPanel = drawPanel;
		this.chart = chart;
		menuBar.start.addActionListener(this);
		menuBar.stop.addActionListener(this);
		menuBar.timeFast.addActionListener(this);
		menuBar.timeNormal.addActionListener(this);
		menuBar.timeSlow.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == menuBar.start) {
			setGameBeingPlayed(true);
		}
		if (src == menuBar.stop) {
			setGameBeingPlayed(false);
			chart.addToDataset();
			chart.saveChart();
		}
		if (src == menuBar.timeSlow) {
			DrawPanel.TIME_PERIOD = 1;
		}
		if (src == menuBar.timeNormal) {
			DrawPanel.TIME_PERIOD = 10;
		}
		if (src == menuBar.timeFast) {
			DrawPanel.TIME_PERIOD = 100;
		}

	}

	public void setGameBeingPlayed(boolean isBeingPlayed) {
		if (isBeingPlayed) {
			menuBar.start.setEnabled(false);
			menuBar.stop.setEnabled(true);
			game = new Thread(drawPanel);
			game.start();
		}
		if (!isBeingPlayed) {
			menuBar.start.setEnabled(true);
			menuBar.stop.setEnabled(false);
			game.interrupt();
		}
	}

}
