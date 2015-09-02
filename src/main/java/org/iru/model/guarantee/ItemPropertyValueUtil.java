package org.iru.model.guarantee;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ItemPropertyValueUtil {

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
	
	public Map.Entry<String, String> validityPeriodParameter(String value) {
		return queryParameters(value, ItemPropertyCodeType.VALIDITY_PERIOD).entrySet().iterator().next();
	}
	
	public String withValidityPeriodParameter(String name, String value) {
		return withQueryParameter(name, value, ItemPropertyCodeType.VALIDITY_PERIOD);
	}
	
}
