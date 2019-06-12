package org.iru.model.guarantee;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractUtil {

	private String substring(String value, String prefix, char separator) {
		if (value.startsWith(prefix + separator)) {
			return value.substring(prefix.length() + 1);
		}
		throw new IllegalArgumentException(value);
	}

	public String anchorValue(String value, String prefix) {
		return substring(value, prefix, '#');
	}
	
	public String withAnchorValue(String anchorValue, String prefix) {
		return prefix + "#" + anchorValue;
	}
	
	public Map<String, String> queryParameters(String value, String prefix) {
		String paramsString = substring(value, prefix, '?');
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

	public String withQueryParameters(Map<String,String> parameters, String prefix) {
		StringBuilder sb = new StringBuilder(prefix);
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

}
