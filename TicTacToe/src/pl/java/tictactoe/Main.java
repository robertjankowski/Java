package pl.java.tictactoe;

import java.awt.EventQueue;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow("TicTacToe");
			}
		});
		
//		Thread thread1 = new Thread() {
//			@Override
//			public void run() {
//				new MainWindow("tt");
//			}
//		};
//		thread1.start();
		
	}

}
