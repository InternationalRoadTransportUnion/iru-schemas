package org.iru.model.guarantee;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ItemPropertyValueUtil {

	public static final String VALIDITY_PERIOD_DURATION = "duration";
	public static final String VALIDITY_PERIOD_FINAL_DATE = "final-date";
	
	public static final String MONETARY_LIMIT_CURRENCY = "currency";
	public static final String MONETARY_LIMIT_VALUE = "value";

	private String substring(String value, ItemPropertyCodeType code, char separator) {
		if (value.startsWith(code.value() + separator)) {
			return value.substring(code.value().length() + 1);
		}
		throw new IllegalArgumentException(value);
	}
	
	public String anchorValue(String value, ItemPropertyCodeType code) {
		return substring(value, code, '#');
	}
	
	public String withAnchorValue(String anchorValue, ItemPropertyCodeType code) {
		return code.value() + "#" + anchorValue;
	}
	
	public Map<String, String> queryParameters(String value, ItemPropertyCodeType code) {
		String paramsString = substring(value, code, '?');
		String[] params = paramsString.split("&");
		Map<String, String> result = new LinkedHashMap<String, String>();
		for (String param : params) {
			int eqIndex = param.indexOf('=');
			if (eqIndex > -1) {
				String k = param.substring(0, eqIndex);
				String v = param.substring(eqIndex + 1);
				result.put(k, v);
			} else {
				result.put(param, null);
			}
		}
		
		return result;
	}
	
	public String withQueryParameters(Map<String,String> parameters, ItemPropertyCodeType code) {
		StringBuilder sb = new StringBuilder(code.value());
		if (parameters != null && ! parameters.isEmpty()) {
			boolean first = true;
			
			for (Map.Entry<String, String> param : parameters.entrySet()) {
				sb.append(first ? "?" : "&");
				sb.append(param.getKey());
				if (param.getValue() != null) {
					sb.append("=").append(param.getValue());
				}
				first = false;
			}
		}
		return sb.toString();
	}
	
	public String withQueryParameter(String name, String value, ItemPropertyCodeType code) {
		return withQueryParameters(Collections.singletonMap(name, value), code);
	}
	
	public String rulesetValue(String value) {
		return anchorValue(value, ItemPropertyCodeType.USAGE_RULESET);
	}
	
	public String withRulesetValue(String value) {
		return withAnchorValue(value, ItemPropertyCodeType.USAGE_RULESET);
	}
	
	public String formatValue(String value) {
		return anchorValue(value, ItemPropertyCodeType.FORMAT);
	}
	
	public String withFormatValue(String value) {
		return withAnchorValue(value, ItemPropertyCodeType.FORMAT);
	}
	
	public String withFormatValue(FormatTypeAnchor value) {
		return withFormatValue(value.value());
	}

	public String withFormatPaperValue() {
		return withFormatValue(FormatTypeAnchor.PAPER);
	}

	public String withFormatElectronicValue() {
		return withFormatValue(FormatTypeAnchor.ELECTRONIC);
	}
	
	public Map.Entry<String, String> validityPeriodParameter(String value) {
		return queryParameters(value, ItemPropertyCodeType.VALIDITY_PERIOD).entrySet().iterator().next();
	}
	
	public String withValidityPeriodParameter(String name, String value) {
		return withQueryParameter(name, value, ItemPropertyCodeType.VALIDITY_PERIOD);
	}

	public String withValidityPeriodDurationParameter(String value) {
		return withValidityPeriodParameter(VALIDITY_PERIOD_DURATION, value);
	}
	
	public String withValidityPeriodFinalDateParameter(String value) {
		return withValidityPeriodParameter(VALIDITY_PERIOD_FINAL_DATE, value);
	}

	public Map<String,String> monetaryLimitParameters(String value) {
		return queryParameters(value, ItemPropertyCodeType.MONETARY_LIMIT);
	}
	
	public String withMonetaryLimitParameters(String currency, int amount) {
		Map<String,String> p = new LinkedHashMap<String, String>();
		p.put(MONETARY_LIMIT_VALUE, Integer.toString(amount));
		p.put(MONETARY_LIMIT_CURRENCY, currency);
		return withQueryParameters(p, ItemPropertyCodeType.MONETARY_LIMIT);
	}
}
