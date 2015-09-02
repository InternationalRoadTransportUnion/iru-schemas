package org.iru.model.guarantee;

import java.net.URI;
import java.net.URISyntaxException;

public enum LegalFrameworkType {

	TIR_CONVENTION("http://www.unece.org/tir/tirconv/conv75.html"),
	ICARNET("http://www.iru.org/trade-facilitation/icarnet");
	
	private URI uri;
	
	private LegalFrameworkType(String uri) {
		try {
			this.uri = new URI(uri);
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	public static LegalFrameworkType fromValue(String uri) {
		for (LegalFrameworkType f : values()) {
			if (f.uri.toString().equals(uri)) {
				return f;
			}
		}
		throw new IllegalArgumentException(uri);
	}
	
	public String value() {
		return uri.toString();
	}
	
	public URI toURI() {
		return uri;
	}
}
