package pl.java.lab7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class EditorPanel extends JPanel {

	JScrollPane scrollPane;
	JTextPane textPane;

	public EditorPanel() {
		this.setLayout(new BorderLayout());
		textPane = new JTextPane();
		scrollPane = new JScrollPane(textPane);
		// przykładowy tekst
		List<String> list = new ArrayList<>();
		try {
			list = loadFile("dyktando.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// list.forEach(item -> System.out.println(item));
		list = formatList(list);
		final String joined = list.stream().collect(Collectors.joining(" "));

		textPane.setFont(new Font("Serif", Font.PLAIN, Preferences.FONT_NORMAL));
		textPane.setBackground(new Color(220, 220, 220));
		textPane.setText(joined);

		this.add(scrollPane, BorderLayout.CENTER);
	}

	// load from file
	private List<String> loadFile(String fileName) throws FileNotFoundException {
		List<String> list = new ArrayList<>();
		Scanner s = new Scanner(new File(fileName), "utf-8");
		while (s.hasNext()) {
			list.add(s.next());
		}
		return list;
	}

	// to change words
	private List<String> formatList(List<String> src) {
		List<String> newList = new ArrayList<>();
		for (String s : src) {
			StringBuilder sb = new StringBuilder(s.length());
			CharacterIterator it = new StringCharacterIterator(s);
			for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
				switch (ch) {
				case 'ó':
				case 'u':
				case 'ż':
				case 'h':
					sb.append("?");
					break;
				default:
					sb.append(ch);
					break;
				}
			}
			newList.add(sb.toString());
		}
		return newList;
	}

	public void changeColor(JTextPane tp, String msg, Color c) {
		StyleContext sc = StyleContext.getDefaultStyleContext();
		AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);
		aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
		String tmp = tp.getText();
		tp.setText("");
		tp.setCharacterAttributes(aset, false);
		tp.setCaretPosition(0);
		tp.replaceSelection(tmp);
	}

}
