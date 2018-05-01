package pl.edu.pw.fizyka.java.lab10.zad2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

public class SwingMySQL extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	JTextField textField = new JTextField();
	JButton button = new JButton("Connect to database");
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	ExecutorService executorService = Executors.newCachedThreadPool();

	public SwingMySQL(String name) {
		super(name);
		setPreferredSize(new Dimension(600, 400));
		add(button, BorderLayout.PAGE_START);
		var panel = new JPanel(new GridLayout(1, 2));
		scrollPane.setBounds(10, 60, 780, 500);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(textField);
		panel.add(scrollPane);
		textArea.setEditable(false);
		add(panel);
		button.addActionListener(e -> {
			executorService.submit(this);
		});
		pack();
		setLocationRelativeTo(null);
	}

	private void connectToDatabase(double number, JTextArea textArea) {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://db4free.net/javaclasses?autoReconnect=true&useSSL=false", "robert", "*********")) {

			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM waluty WHERE USD < ?");
			preparedStatement.setDouble(1, number);

			ResultSet rs = preparedStatement.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			var x = new StringBuilder();
			int column = md.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= column; i++) {
					if (i > 1) {
						x.append(",  ");
					}
					String columnValue = rs.getString(i);
					x.append(columnValue + " " + md.getColumnName(i));
				}
				x.append('\n');
			}
			textArea.setText(x.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			var number = Double.parseDouble(textField.getText());
			connectToDatabase(number, textArea);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			textArea.setText("You have to write a number");
		}

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new SwingMySQL("Swing and MySQL").setVisible(true);
		});
	}
}
