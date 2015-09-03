package org.iru.model.guarantee;

public enum FormatTypeAnchor {
	PAPER("paper"),
	ELECTRONIC("electronic");

	private String value;

	private FormatTypeAnchor(String value) {
		this.value = value;
	}

	public static FormatTypeAnchor fromValue(String value) {
		for (FormatTypeAnchor f : values()) {
			if (f.value.equals(value)) {
				return f;
			}
		}
		throw new IllegalArgumentException(value);
	}

	public String toString() {
		return value;
	}

	public String value() {
		return value;
	}

}