package pl.edu.pw.fizyka.java.lab10.zad1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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

@SuppressWarnings("serial")
public class SwingH2 extends JFrame implements ActionListener {

	JTextField textField = new JTextField(
			"INSERT INTO `waluty` (`Id`,`data`,`USD`,`EUR`,`GBP`) VALUES (1,'2000-01-03',4.1171,4.165,6.6576)");
	JButton button = new JButton("Connect to database");
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	SqlQuery sqlQuery;
	ExecutorService service = Executors.newCachedThreadPool();

	public SwingH2(String name) {
		super(name);
		setPreferredSize(new Dimension(1400, 400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(button, BorderLayout.PAGE_START);
		var panel = new JPanel(new GridLayout(1, 2));
		scrollPane.setBounds(10, 60, 780, 500);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(textField);
		panel.add(scrollPane);
		textArea.setEditable(false);
		add(panel);
		button.addActionListener(this);
		pack();
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new SwingH2("Swing & H2").setVisible(true);
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(button)) {
			service.execute(() -> {
				if (!connectToDatabase()) {
					textArea.setText(textField.getText() + "\n Error,incorrect query");
				}
			});
		}
	}

	private boolean connectToDatabase() {
		var text = textField.getText();
		String intro = text.split(" ")[0].toUpperCase();
		switch (SqlQuery.valueOf(intro)) {
		case SELECT:
			selectFromDatabase(text);
			break;
		case INSERT:
			insertIntoDatabase(text);
			break;
		case DELETE:
			deleteFromDatabase(text);
			break;
		case UPDATE:
			updateDatabase(text);
			break;
		default:
			textArea.setText("wrong query");
			return false;
		}

		return true;
	}

	private void selectFromDatabase(String text) {
		try {
			try (Connection conn = DriverManager.getConnection("jdbc:h2:./data/nazwabazy", "sa", "")) {
				Statement statement = conn.createStatement();
				statement.execute(text);
				ResultSet rs = statement.getResultSet();
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
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	private void insertIntoDatabase(String text) {
		try {
			try (Connection conn = DriverManager.getConnection("jdbc:h2:./data/nazwabazy", "sa", "")) {
				Statement statement = conn.createStatement();
				statement.execute(text);
				textArea.setText("Inserted into database");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	private void deleteFromDatabase(String text) {
		try {
			try (Connection conn = DriverManager.getConnection("jdbc:h2:./data/nazwabazy", "sa", "")) {
				Statement statement = conn.createStatement();
				statement.execute(text);
				textArea.setText("Delected from database");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	private void updateDatabase(String text) {
		try {
			try (Connection conn = DriverManager.getConnection("jdbc:h2:./data/nazwabazy", "sa", "")) {
				Statement statement = conn.createStatement();
				statement.execute(text);
				textArea.setText("Database updated");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

}
