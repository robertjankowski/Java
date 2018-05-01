package pl.edu.pw.fizyka.java.lab10.zad1;

public enum SqlQuery {

	SELECT("SELECT"), INSERT("INSERT"), DELETE("DELETE"), UPDATE("UPDATE");
	@SuppressWarnings("unused")
	private final String name;

	private SqlQuery(String name) {
		this.name = name;
	}
}
