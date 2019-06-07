package org.iru.model.guarantee;

public class UsageRuleValueUtil {

    private static final String _ADDENDUM = "-addendum";

	public String withVoletCount(short voletCount) {
        return withAnchorValue(Short.toString(voletCount), UsageRule.VOLET_COUNT);
    }
    
    public String withAddendum(String subusageItemIdentificationPart) {
    	return withAnchorValue(subusageItemIdentificationPart+_ADDENDUM, UsageRule.DEED_OF_ENGAGEMENT);
    }
    
    public String withAnchorValue(String anchorValue, UsageRule usageRule) {
        return usageRule.getURI() + "#" + anchorValue;
    }
    
    private String substring(String value, UsageRule rule, char separator) {
		if (value.startsWith(rule.getURI() + separator)) {
			return value.substring(rule.getURI().length() + 1);
		}
		throw new IllegalArgumentException(value);
	}

	public String anchorValue(String value, UsageRule rule) {
		return substring(value, rule, '#');
	}
	
	public String deedOfEngagementAddendumSubusageValue(String value) {
		String addendum = anchorValue(value, UsageRule.DEED_OF_ENGAGEMENT);
		return addendum.substring(0, addendum.length() - _ADDENDUM.length());
	}

	public String voletCountValue(String value) {
		return anchorValue(value, UsageRule.VOLET_COUNT);
	}
	
}
