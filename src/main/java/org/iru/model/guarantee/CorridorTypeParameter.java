package org.iru.model.guarantee;

public enum CorridorTypeParameter {
	ONE_WAY("one-way"),
	TWO_WAY("two-way");

	private String value;

	private CorridorTypeParameter(String value) {
		this.value = value;
	}

	public static CorridorTypeParameter fromValue(String value) {
		for (CorridorTypeParameter f : values()) {
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