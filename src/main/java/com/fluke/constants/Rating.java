package com.fluke.constants;

public enum Rating {
	G("G"),
	PG("PG"),
	PG13("PG-13"),
	R("R"),
	NC17("NC-17");
	
	private String label;

	private Rating(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}
