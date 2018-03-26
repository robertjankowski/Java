package pl.java.lab5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAndLabelListener implements ActionListener{

	ToolsPanel toolsPanel;
	BottomPanel bottomPanel;
	
	public ButtonAndLabelListener(ToolsPanel toolsPanel,BottomPanel bottomPanel) {
		this.toolsPanel = toolsPanel;
		this.bottomPanel = bottomPanel;
		toolsPanel.eraser.addActionListener(this);
		toolsPanel.circle.addActionListener(this);
		toolsPanel.line.addActionListener(this);
		toolsPanel.pencil.addActionListener(this);
		toolsPanel.rectangle.addActionListener(this);
		toolsPanel.fillShape.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == toolsPanel.eraser) {
			bottomPanel.label.setText(toolsPanel.eraser.getName());
		}
		if(ob == toolsPanel.line) {
			bottomPanel.label.setText(toolsPanel.line.getName());
		}
		if(ob == toolsPanel.circle) {
			bottomPanel.label.setText(toolsPanel.circle.getName());
		}
		if(ob == toolsPanel.pencil) {
			bottomPanel.label.setText(toolsPanel.pencil.getName());
		}
		if(ob == toolsPanel.rectangle) {
			bottomPanel.label.setText(toolsPanel.rectangle.getName());
		}
		if(ob == toolsPanel.fillShape) {
			bottomPanel.label.setText(toolsPanel.fillShape.getName());
		}
		
	}

}
