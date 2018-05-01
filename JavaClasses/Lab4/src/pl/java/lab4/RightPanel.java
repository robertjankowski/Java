package pl.java.lab4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RightPanel extends JPanel {

	JLabel xPos;
	JLabel yPos;
	List<JTextField> xPosList;
	List<JTextField> yPosList;
	JPanel labelPanel;
	JPanel textPanel;
	LeftPanel leftPanel;

	public RightPanel(LeftPanel leftPanel) {
		this.leftPanel = leftPanel;
		init();
		calculate();
	}

	public void init() {
		xPos = new JLabel("X pos.");
		yPos = new JLabel("Y pos.");
		this.setLayout(new BorderLayout());
		labelPanel = new JPanel();
		textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(TopPanel.vertices, 2));
		xPosList = new ArrayList<>(TopPanel.vertices);
		yPosList = new ArrayList<>(TopPanel.vertices);
		labelPanel.add(xPos);
		labelPanel.add(yPos);
		this.add(labelPanel, BorderLayout.PAGE_START);
		this.add(textPanel, BorderLayout.CENTER);
	}

	public void calculate() {
		if (leftPanel.getMode() == LeftPanel.REGULAR) {
			for (int i = 0; i < TopPanel.vertices; i++) {
				xPosList.add(i, new JTextField(
						(int) ((int) CenterPanel.RADIUS * Math.cos((Math.PI / 2 + 2 * Math.PI * i) / TopPanel.vertices)
								+ CenterPanel.START_POSITION_X) + ""));
				yPosList.add(i, new JTextField(
						(int) ((int) CenterPanel.RADIUS * Math.sin((Math.PI / 2 + 2 * Math.PI * i) / TopPanel.vertices)
								+ CenterPanel.START_POSITION_Y) + ""));
				textPanel.add(xPosList.get(i));
				textPanel.add(yPosList.get(i));
			}
		} else {
			for (int i = 0; i < TopPanel.vertices; i++) {
				Random random = new Random();
				xPosList.add(i, new JTextField((int) (random.nextInt(300) - 150 + CenterPanel.START_POSITION_X) + ""));
				yPosList.add(i, new JTextField((int) (random.nextInt(300) - 150 + CenterPanel.START_POSITION_Y) + ""));
				textPanel.add(xPosList.get(i));
				textPanel.add(yPosList.get(i));
			}
		}
	}

	public void changeVertices() {
		removeAll();
		xPosList.clear();
		yPosList.clear();
		init();
		this.revalidate();
		this.repaint();
	}

	List<JTextField> getxPosList() {
		return xPosList;
	}

	List<JTextField> getyPosList() {
		return yPosList;
	}
}
