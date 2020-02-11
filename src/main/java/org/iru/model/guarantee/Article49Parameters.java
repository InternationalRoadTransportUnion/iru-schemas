package org.iru.model.guarantee;

import java.util.List;

public class Article49Parameters {
	private FormatTypeAnchor format;
	private List<String> countries;

	private Article49Parameters(Builder builder) {
		setFormat(builder.format);
		setCountries(builder.countries);
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static Builder newBuilder(Article49Parameters copy) {
		Builder builder = new Builder();
		builder.format = copy.getFormat();
		builder.countries = copy.getCountries();
		return builder;
	}

	public FormatTypeAnchor getFormat() {
		return format;
	}

	public void setFormat(FormatTypeAnchor format) {
		this.format = format;
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public static final class Builder {
		private FormatTypeAnchor format;
		private List<String> countries;

		private Builder() {
		}

		public Builder withFormat(FormatTypeAnchor val) {
			format = val;
			return this;
		}

		public Builder withCountries(List<String> val) {
			countries = val;
			return this;
		}

		public Article49Parameters build() {
			return new Article49Parameters(this);
		}
	}
}
