package org.iru.model.guarantee;

public class UsageRuleValueUtil {

    public static final String PILOT_ADDENDUM = "pilot-addendum";
    public static final String TOBACCO_ADDENDUM = "tobacco-addendum";
    public static final String TOBACCOALCOHOL_ADDENDUM = "tobaccoalcohol-addendum";
    
    public String withVoletCount(short voletCount) {
        return withAnchorValue(Short.toString(voletCount), UsageRule.VOLET_COUNT);
    }
    
    public String withPilotAddendum() {
        return withAnchorValue(PILOT_ADDENDUM, UsageRule.DEED_OF_ENGAGEMENT);
    }

    public String withTobaccoAddendum() {
        return withAnchorValue(TOBACCO_ADDENDUM, UsageRule.DEED_OF_ENGAGEMENT);
    }

    public String withTobaccoAlcoholAddendum() {
        return withAnchorValue(TOBACCOALCOHOL_ADDENDUM, UsageRule.DEED_OF_ENGAGEMENT);
    }

    
    public String withAnchorValue(String anchorValue, UsageRule usageRule) {
        return usageRule.getURI() + "#" + anchorValue;
    }

}
