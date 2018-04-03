package pl.gameoflife;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OptionsPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 3171205259777881612L;
	private static final int PREFERRED_WIDTH = 210;
	JSlider timeChange;
	JSlider blockSize;

	JRadioButton glider; // Ship
	JRadioButton point;
	JRadioButton lightweight; // Ship
	JRadioButton caterer; // Oscillator
	JRadioButton figureEight; // Oscillator

	Recording recorder;
	JButton startRecord;
	JButton stopRecord;

	JPanel recordPanel;
	JPanel sliderPanel;
	JPanel buttonsPanel;

	public OptionsPanel(GameBoard gameBoard) throws AWTException {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(PREFERRED_WIDTH, MainFrame.HEIGHT));
		Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Options");
		this.setBorder(border);
		sliderPanel = new JPanel(new GridLayout(2, 1, 1, 30));
		buttonsPanel = new JPanel(new GridLayout(5, 1, 1, 30));
		recordPanel = new JPanel();
		border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Recording options");
		recordPanel.setBorder(border);
		border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
				"Pick ship or oscillator");
		buttonsPanel.setBorder(border);

		// time options and size of grid
		timeChange = new JSlider(1, 80, 5);
		timeChange.setMinorTickSpacing(10);
		timeChange.setMajorTickSpacing(5);
		timeChange.setPaintTicks(true);
		blockSize = new JSlider(5, 20, 15);
		blockSize.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				GameBoard.BLOCK_SIZE = (Integer) blockSize.getValue();
				gameBoard.setGameBoardSize(new Dimension(gameBoard.getWidth() / GameBoard.BLOCK_SIZE - 2,
						gameBoard.getHeight() / GameBoard.BLOCK_SIZE - 2));
				gameBoard.updateArraySize();
			}
		});
		blockSize.setMajorTickSpacing(5);
		blockSize.setPaintTicks(true);
		blockSize.setPaintLabels(true);
		border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Size of the grid");
		blockSize.setBorder(border);
		border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Simulation speed");
		timeChange.setBorder(border);
		timeChange.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				GameBoard.TIME_PERIOD = (Integer) timeChange.getValue();
			}
		});

		// ships and oscillators
		glider = new JRadioButton("Glider");
		glider.setContentAreaFilled(true);
		point = new JRadioButton("Point");
		point.setSelected(true);
		lightweight = new JRadioButton("Lightweight Spaceship");
		caterer = new JRadioButton("Caterer");
		figureEight = new JRadioButton("Figure eight");
		figureEight.addActionListener(this);
		caterer.addActionListener(this);
		lightweight.addActionListener(this);
		glider.addActionListener(this);
		point.addActionListener(this);
		ButtonGroup group = new ButtonGroup();
		group.add(glider);
		group.add(point);
		group.add(lightweight);
		group.add(caterer);
		group.add(figureEight);

		// recording
		GroupLayout groupLayout = new GroupLayout(recordPanel);
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setAutoCreateGaps(true);
		startRecord = new JButton("Start");
		stopRecord = new JButton("Stop");
		stopRecord.addActionListener(this);
		startRecord.addActionListener(this);
		stopRecord.setEnabled(false);
		recorder = new Recording("output.mp4", 10, Quality.HIGH);
		groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup().addComponent(startRecord).addGap(30)
				.addGroup(groupLayout.createSequentialGroup().addGroup(
						groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(stopRecord))));
		groupLayout.setVerticalGroup(groupLayout.createSequentialGroup().addComponent(startRecord, 50, 50, 50).addGap(2)
				.addComponent(stopRecord, 50, 50, 50));
		sliderPanel.add(timeChange);
		sliderPanel.add(blockSize);
		recordPanel.setLayout(groupLayout);

		buttonsPanel.add(point);
		buttonsPanel.add(glider);
		buttonsPanel.add(lightweight);
		buttonsPanel.add(caterer);
		buttonsPanel.add(figureEight);

		this.add(sliderPanel);
		this.add(recordPanel);
		this.add(buttonsPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(glider)) {
			GameBoard.CURRENT_SHIP = NamesOfShipsAndOscillators.GLIDER;
		}
		if (e.getSource().equals(point)) {
			GameBoard.CURRENT_SHIP = NamesOfShipsAndOscillators.POINT;
		}
		if (e.getSource().equals(lightweight)) {
			GameBoard.CURRENT_SHIP = NamesOfShipsAndOscillators.LIGHTWEIGHT_SPACESHIP;
		}
		if (e.getSource().equals(caterer)) {
			GameBoard.CURRENT_SHIP = NamesOfShipsAndOscillators.CATERER;
		}
		if (e.getSource().equals(figureEight)) {
			GameBoard.CURRENT_SHIP = NamesOfShipsAndOscillators.FIGURE_EIGHT;
		}
		if (e.getSource().equals(startRecord)) {
			recorder.startCapture();
			startRecord.setEnabled(false);
			stopRecord.setEnabled(true);
		}
		if (e.getSource().equals(stopRecord)) {
			recorder.stopCapture();
			startRecord.setEnabled(true);
			stopRecord.setEnabled(false);
		}
	}

}
