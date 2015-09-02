package org.iru.model.guarantee;

import java.net.URI;
import java.net.URISyntaxException;

public enum ItemPropertyCodeType {

	LEGAL_FRAMEWORK("http://www.iru.org/model/guarantee-1/legal-framework"),
	USAGE_RULESET("http://www.iru.org/model/guarantee-1/usage-rule-set"),
	FORMAT("http://www.iru.org/model/guarantee-1/format"),
	VALIDITY_PERIOD("http://www.iru.org/model/guarantee-1/validity-period"),
	MONETARY_LIMIT("http://www.iru.org/model/guarantee-1/monetary-limit");
	
	private URI uri;
	
	private ItemPropertyCodeType(String uri) {
		try {
			this.uri = new URI(uri);
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	public static ItemPropertyCodeType fromValue(String uri) {
		for (ItemPropertyCodeType f : values()) {
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
