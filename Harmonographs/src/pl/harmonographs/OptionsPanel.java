package pl.harmonographs;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class OptionsPanel extends JPanel {

	JRadioButton start;
	JRadioButton stop;
	JButton reset;
	JButton speed;
	JPanel startPanel;
	JPanel leftPanel;
	JPanel allConstPanel;
	JPanel resetPanel;
	JPanel freqPanel;
	JPanel constPanel;
	JComboBox<Object>[] freqChosser = new JComboBox[4];
	JComboBox<Object>[] constChooser = new JComboBox[4];

	DrawPanel drawPanel;

	public OptionsPanel(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		this.setLayout(new GridLayout(1, 3, 10, 10));
		start = new JRadioButton("Start");
		stop = new JRadioButton("Stop");
		reset = new JButton("Reset");
		speed = new JButton("Speed up");
		for (int i = 0; i < constChooser.length; i++) {
			freqChosser[i] = new JComboBox<Object>(new Object[] { "f" + (i + 1), 0.01, 0.1, 5, 3, 10 });
			constChooser[i] = new JComboBox<>(new Object[] { "d" + (i + 1), 0.01, 0.004, 0.002, 0.1 });
		}

		for (int i = 0; i < freqChosser.length; i++) {
			freqChosser[i].addActionListener(e -> {
				if (freqChosser[0].getSelectedIndex() > 0) {
					DrawPanel.f1 = freqChosser[0].getSelectedIndex();
				}
				if (freqChosser[1].getSelectedIndex() > 0) {
					DrawPanel.f2 = freqChosser[1].getSelectedIndex();
				}
				if (freqChosser[2].getSelectedIndex() > 0) {
					DrawPanel.f3 = freqChosser[2].getSelectedIndex();
				}
				if (freqChosser[3].getSelectedIndex() > 0) {
					DrawPanel.f4 = freqChosser[3].getSelectedIndex();
				}
				drawPanel.resetPanel();
				repaint();

			});
		}
		for (int i = 0; i < constChooser.length; i++) {
			constChooser[i].addActionListener(e -> {
				if (constChooser[0].getSelectedIndex() > 0) {
					DrawPanel.d1 = constChooser[0].getSelectedIndex();
				}
				if (constChooser[1].getSelectedIndex() > 0) {
					DrawPanel.d2 = constChooser[1].getSelectedIndex();
				}
				if (constChooser[2].getSelectedIndex() > 0) {
					DrawPanel.d3 = constChooser[2].getSelectedIndex();
				}
				if (constChooser[3].getSelectedIndex() > 0) {
					DrawPanel.d4 = constChooser[3].getSelectedIndex();
				}
				drawPanel.resetPanel();
				repaint();
			});
		}
		reset.addActionListener(e -> {
			drawPanel.resetPanel();
			repaint();
		});
		speed.addActionListener(e -> {
			DrawPanel.waitTime += 10;
		});

		resetPanel = new JPanel();
		leftPanel = new JPanel(new GridLayout(2, 1, 5, 5));
		allConstPanel = new JPanel(new GridLayout(2, 1, 10, 10));
		constPanel = new JPanel();
		allConstPanel
				.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2), "Options"));
		startPanel = new JPanel();
		freqPanel = new JPanel(new GridLayout(1, 2));
		ButtonGroup group = new ButtonGroup();
		group.add(start);
		group.add(stop);
		start.addActionListener(e -> {
			startThread(true);
		});
		stop.addActionListener(e -> {
			startThread(false);
		});
		startPanel.add(start);
		startPanel.add(stop);
		resetPanel.add(reset);
		resetPanel.add(speed);
		for (int i = 0; i < freqChosser.length; i++) {
			freqPanel.add(freqChosser[i]);
		}
		for (int i = 0; i < constChooser.length; i++) {
			constPanel.add(constChooser[i]);
		}

		allConstPanel.add(freqPanel);
		allConstPanel.add(constPanel);
		leftPanel.add(startPanel);
		leftPanel.add(resetPanel);
		this.add(leftPanel);
		this.add(allConstPanel);

	}

	private void startThread(boolean b) {
		if (b) {
			drawPanel.start();
		} else {
			drawPanel.stop();
		}
	}
}
