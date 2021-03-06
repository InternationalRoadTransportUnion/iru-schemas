package org.iru.model.guarantee;

public enum UsageRule {
    
	/*
	 * Keep in sync with ItemPropertyCodeType.USAGE_RULE_*
	 */
    VOLET_COUNT("http://www.iru.org/model/guarantee-1/volet"),
    DEED_OF_ENGAGEMENT("http://www.iru.org/model/association/deed-of-engagement"),
    CORRIDOR("http://www.iru.org/model/guarantee-1/corridor"),
    EPD_TOKEN_WAIVER("http://www.iru.org/model/guarantee-1/epd-token-waiver"),
    ARTICLE_49("http://www.unece.org/tir/tirconv/conv75/article49.html"),
    ETIR_MESSAGES("http://www.iru.org/model/guarantee-1/etir-messages");
    
    private final String uri;

    private UsageRule(String uri) {
        this.uri = uri;
    }

    public String getURI() {
        return uri;
    }
        
}
