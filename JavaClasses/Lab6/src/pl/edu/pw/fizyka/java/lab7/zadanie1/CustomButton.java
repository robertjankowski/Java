package pl.edu.pw.fizyka.java.lab7.zadanie1;

import java.awt.Color;

import javax.swing.JButton;

public class CustomButton extends JButton implements Runnable {

	private static long START_TIME;
	private static long FINAL_TIME = 20000;
	public static boolean isTime = true;
	int counter = 0;
	Thread thread;

	public CustomButton() {
		this.setText("Hello");
		thread = new Thread(this);
		thread.start();
		this.setEnabled(false);
	}

	@Override
	public void run() {
		START_TIME = System.currentTimeMillis();
		while (isTime) {
			if (System.currentTimeMillis() - START_TIME > FINAL_TIME) {
				isTime = false;
				System.exit(0);
			}
			this.setText("World " + counter);
			try {
				Thread.sleep(500);
				this.setText("Hello " + counter);
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			counter++;
		}
	}

}
