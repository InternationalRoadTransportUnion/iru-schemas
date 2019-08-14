package org.iru.model.guarantee;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UsageRuleValueUtil extends AbstractUtil {

    private static final String _ADDENDUM = "-addendum";
    
	public static final String CORRIDOR_TYPE = "type";
	public static final String CORRIDOR_COUNTRIES = "countries";

    public String withAnchorValue(String anchorValue, UsageRule usageRule) {
        return withAnchorValue(anchorValue, usageRule.getURI());
    }
    
	public String anchorValue(String value, UsageRule rule) {
		return super.anchorValue(value, rule.getURI());
	}

	public String withVoletCount(short voletCount) {
        return withAnchorValue(Short.toString(voletCount), UsageRule.VOLET_COUNT);
    }
    
    public String withAddendum(String subusageItemIdentificationPart) {
    	return withAnchorValue(subusageItemIdentificationPart+_ADDENDUM, UsageRule.DEED_OF_ENGAGEMENT);
    }
	
	public String deedOfEngagementAddendumSubusageValue(String value) {
		String addendum = anchorValue(value, UsageRule.DEED_OF_ENGAGEMENT);
		return addendum.substring(0, addendum.length() - _ADDENDUM.length());
	}

	public String voletCountValue(String value) {
		return anchorValue(value, UsageRule.VOLET_COUNT);
	}
	
	public Map<String,String> corridorParameters(String value) {
		return queryParameters(value, UsageRule.CORRIDOR.getURI());
	}
	
	public CorridorParameters toCorridorParameters(String value) {
		Map<String,String> qp = queryParameters(value, UsageRule.CORRIDOR.getURI());
		return toCorridorParameters(qp);
	}

	public CorridorParameters toCorridorParameters(Map<String, String> queryParameters) {
		CorridorTypeParameter t = CorridorTypeParameter.fromValue(queryParameters.get(CORRIDOR_TYPE));
		List<String> c = Arrays.asList(queryParameters.get(CORRIDOR_COUNTRIES).split(","));
		CorridorParameters cp = new CorridorParameters();
		cp.setType(t);
		cp.setCountries(c);
		return cp;
	}
	
	public String withCorridorParameters(CorridorParameters corridorParameters) {
		return withCorridorParameters(corridorParameters.getType(), corridorParameters.getCountries());
	}
	
	public String withCorridorParameters(CorridorTypeParameter corridorType, List<String> iso3CountryList) {
		Map<String,String> p = new LinkedHashMap<String, String>();
		p.put(CORRIDOR_TYPE, corridorType.value());
		p.put(CORRIDOR_COUNTRIES, String.join(",", iso3CountryList));
		return withQueryParameters(p, UsageRule.CORRIDOR.getURI());
	}
	
}
