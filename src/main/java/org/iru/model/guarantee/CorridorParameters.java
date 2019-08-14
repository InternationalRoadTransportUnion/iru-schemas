package org.iru.model.guarantee;

import java.util.List;

public class CorridorParameters {

	private CorridorTypeParameter type;
	private List<String> countries;
	
	public CorridorTypeParameter getType() {
		return type;
	}
	public void setType(CorridorTypeParameter type) {
		this.type = type;
	}
	public List<String> getCountries() {
		return countries;
	}
	public void setCountries(List<String> countries) {
		this.countries = countries;
	}
	
}
