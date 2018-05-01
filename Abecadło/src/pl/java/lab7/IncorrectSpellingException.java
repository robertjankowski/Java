package pl.java.lab7;

import java.util.List;

public class IncorrectSpellingException extends Exception {

	// tu coś pewnie do poprawy
	private List<String> words;

	public IncorrectSpellingException(List<String> words) {
		this.words = words;
	}

	@Override
	public String getMessage() {
		return "Incorrect word" + super.getMessage();
	}

	public List<String> getWords() {
		return words;
	}

}
