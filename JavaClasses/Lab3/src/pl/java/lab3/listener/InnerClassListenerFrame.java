package pl.java.lab3.listener;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class InnerClassListenerFrame extends JFrame {

	public InnerClassListenerFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 50);
		label = new JLabel("0");
		slider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
		this.add(slider, BorderLayout.PAGE_START);
		this.add(label);

		// slider.addChangeListener(new SliderChangeListener());
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				label.setText(slider.getValue() + "");
			}
		});
	}

	private class SliderChangeListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			String value = slider.getValue() + ""; // String.format("%d",slider.getValue());
			label.setText(value);
		}

	}

	public static void main(String[] args) {
		new InnerClassListenerFrame().setVisible(true);
	}

	public static final int SLIDER_MIN = -100;
	public static final int SLIDER_MAX = 100;
	public static final int SLIDER_INIT = 0;

	private JLabel label;
	private JSlider slider;

}
