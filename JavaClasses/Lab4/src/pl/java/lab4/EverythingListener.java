package pl.java.lab4;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class EverythingListener implements ChangeListener, ActionListener {

	TopPanel topPanel;
	BottomPanel bottomPanel;
	LeftPanel leftPanel;
	RightPanel rightPanel;
	CenterPanel centerPanel;
	int counterRandom = 0;
	int counterRegular = 0;

	public EverythingListener(TopPanel topPanel, BottomPanel bottomPanel, LeftPanel leftPanel, RightPanel rightPanel,
			CenterPanel centerPanel) {
		this.topPanel = topPanel;
		this.bottomPanel = bottomPanel;
		this.leftPanel = leftPanel;
		this.rightPanel = rightPanel;
		this.centerPanel = centerPanel;
		topPanel.slider.addChangeListener(this);
		topPanel.drawButton.addActionListener(this);
		leftPanel.random.addActionListener(this);
		leftPanel.regular.setToolTipText("Change x and y position and click me, than click Draw");
		leftPanel.regular.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == leftPanel.random) {
			leftPanel.mode = LeftPanel.RANDOM;
			counterRandom++;
		} else if (e.getSource() == leftPanel.regular) {
			leftPanel.mode = LeftPanel.REGULAR;
			counterRegular++;
		} else if (e.getSource() == topPanel.drawButton) {
			if (TopPanel.vertices == topPanel.slider.getValue() && leftPanel.regular.isSelected()) {
				if (counterRandom > 0) {
					drawMoreVertices();
					counterRandom = 0;
				} else if (counterRegular > 0) {
					centerPanel.setPolygon();
					centerPanel.repaint();
					counterRegular = 0;
				} else {
					drawMoreVertices();
					counterRegular = 0;
				}
			} else {
				drawMoreVertices();
			}
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		TopPanel.vertices = topPanel.slider.getValue();
		rightPanel.changeVertices();
		rightPanel.calculate();
		centerPanel.setPolygon();
		centerPanel.repaint();
	}

	public void drawMoreVertices() {
		int length = rightPanel.getxPosList().size();
		int[] xPos = new int[length];
		int[] yPos = new int[length];
		rightPanel.changeVertices();
		rightPanel.calculate();
		for (int i = 0; i < length; i++) {
			xPos[i] = Integer.parseInt(rightPanel.getxPosList().get(i).getText());
			yPos[i] = Integer.parseInt(rightPanel.getyPosList().get(i).getText());
		}
		centerPanel.poly = new Polygon(xPos, yPos, length);
		centerPanel.repaint();
	}

}
