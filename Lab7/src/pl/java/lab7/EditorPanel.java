package pl.java.lab7;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class EditorPanel extends JPanel {

	JScrollPane scrollPane;
	JTextPane textPane;

	public EditorPanel() {
		this.setLayout(new BorderLayout());
		textPane = new JTextPane();
		scrollPane = new JScrollPane(textPane);

		// czytanie z pliku przykładowe
		try {
			FileInputStream fstream = new FileInputStream("dyktando-short.txt");
			InputStreamReader instream = new InputStreamReader(fstream, "UTF-8");
			BufferedReader reader = new BufferedReader(instream);
			StringBuffer buffer = new StringBuffer();

			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			textPane.setText(buffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.add(scrollPane, BorderLayout.CENTER);
	}

}
