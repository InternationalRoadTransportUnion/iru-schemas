package org.iru.model.guarantee;

public enum UsageRuleEnum {
    
    VOLET_COUNT("http://www.iru.org/model/guarantee-1/volet"),
    PILOT("http://www.iru.org/model/association/deed-of-engagement#pilot-addendum");
    
    private final String uri;

    private UsageRuleEnum(String uri) {
        this.uri = uri;
    }

    public String getURI() {
        return uri;
    }
    
}
