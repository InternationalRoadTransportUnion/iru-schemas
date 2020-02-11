package org.iru.model.guarantee;

import java.net.URI;
import java.net.URISyntaxException;

public enum ItemPropertyCodeType {

	LEGAL_FRAMEWORK("http://www.iru.org/model/guarantee-1/legal-framework"),
	USAGE_RULESET("http://www.iru.org/model/guarantee-1/usage-rule-set"),
	USAGE_RULE_VOLET_COUNT(UsageRule.VOLET_COUNT),
	USAGE_RULE_DEED_OF_ENGAGEMENT(UsageRule.DEED_OF_ENGAGEMENT),
	USAGE_RULE_CORRIDOR(UsageRule.CORRIDOR),
	USAGE_RULE_EPD_TOKEN_WAIVER(UsageRule.EPD_TOKEN_WAIVER),
	USAGE_RULE_ARTICLE_49(UsageRule.ARTICLE_49),
	USAGE_RULE_ETIR_MESSAGES(UsageRule.ETIR_MESSAGES),
	FORMAT("http://www.iru.org/model/guarantee-1/format"),
	VALIDITY_PERIOD("http://www.iru.org/model/guarantee-1/validity-period"),
	MONETARY_LIMIT("http://www.iru.org/model/guarantee-1/monetary-limit");
	
	private URI uri;
	
	private ItemPropertyCodeType(UsageRule usageRule) {
		this(usageRule.getURI());
	}
	
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
