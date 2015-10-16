package org.iru.model.guarantee;

public enum UsageRuleEnum {
    
    VOLET_COUNT_4("http://www.iru.org/model/guarantee-1/volet#4"),
    VOLET_COUNT_6("http://www.iru.org/model/guarantee-1/volet#6"),
    VOLET_COUNT_14("http://www.iru.org/model/guarantee-1/volet#14"),
    VOLET_COUNT_20("http://www.iru.org/model/guarantee-1/volet#20"),
    PILOT("http://www.iru.org/model/association/deed-of-engagement#pilot-addendum");
    
    private final String URI;

    private UsageRuleEnum(String URI) {
        this.URI = URI;
    }

    public String getURI() {
        return URI;
    }
    
}
