package org.iru.model.guarantee;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class ItemPropertyValueUtilTest {

	private static final String FOUR = "4";
	private static final String HTTP_WWW_IRU_ORG_MODEL_GUARANTEE_1_USAGE_RULE_SET_4 = "http://www.iru.org/model/guarantee-1/usage-rule-set#4";

	private static final String HTTP_WWW_IRU_ORG_MODEL_GUARANTEE_1_FORMAT_PAPER = "http://www.iru.org/model/guarantee-1/format#paper";

	private static final String SIXTY_DAYS = "P60D";
	private static final String HTTP_WWW_IRU_ORG_MODEL_GUARANTEE_1_VALIDITY_PERIOD_DURATION_P60D = "http://www.iru.org/model/guarantee-1/validity-period?duration=P60D";
	
	private static final String CURRENCY = ItemPropertyValueUtil.MONETARY_LIMIT_CURRENCY;
	private static final String EURO = "EUR";
	private static final String VALUE = ItemPropertyValueUtil.MONETARY_LIMIT_VALUE;
	private static final int SIXTY_THOUSAND = 60000;
	
	private static final String HTTP_WWW_IRU_ORG_MODEL_GUARANTEE_1_MONETARY_LIMIT_VALUE_60000_CURRENCY_EUR = "http://www.iru.org/model/guarantee-1/monetary-limit?value=60000&currency=EUR";
	
	public ItemPropertyValueUtil util = new ItemPropertyValueUtil();
	
	@Test
	public void ruletSetValue4Test() {
		String ruleset = HTTP_WWW_IRU_ORG_MODEL_GUARANTEE_1_USAGE_RULE_SET_4;
		String four = util.rulesetValue(ruleset);
		Assert.assertEquals(FOUR, four);
	}

	@Test
	public void withRuletSetValue4Test() {
		String four = FOUR;
		String ruleset = util.withRulesetValue(four);
		Assert.assertEquals(HTTP_WWW_IRU_ORG_MODEL_GUARANTEE_1_USAGE_RULE_SET_4, ruleset);
	}

	@Test
	public void formatValuePaperTest() {
		String paperFormat = HTTP_WWW_IRU_ORG_MODEL_GUARANTEE_1_FORMAT_PAPER;
		String paper = util.formatValue(paperFormat);
		Assert.assertEquals(ItemPropertyValueUtil.FORMAT_PAPER, paper);
	}
	
	@Test
	public void withFormatValuePaperTest() {
		String paperFormat = util.withFormatPaperValue();
		Assert.assertEquals(HTTP_WWW_IRU_ORG_MODEL_GUARANTEE_1_FORMAT_PAPER, paperFormat);
	}
	
	@Test
	public void validityPeriodDurationSixtyDaysTest() {
		String validityPeriod = HTTP_WWW_IRU_ORG_MODEL_GUARANTEE_1_VALIDITY_PERIOD_DURATION_P60D;
		Map.Entry<String,String> validityPeriodParam = util.validityPeriodParameter(validityPeriod);
		Assert.assertEquals(ItemPropertyValueUtil.VALIDITY_PERIOD_DURATION, validityPeriodParam.getKey());
		Assert.assertEquals(SIXTY_DAYS, validityPeriodParam.getValue());
	}
	
	@Test
	public void withValidityPeriodDurationSixtyDaysTest() {
		String validityPeriod = util.withValidityPeriodDurationParameter(SIXTY_DAYS);
		Assert.assertEquals(HTTP_WWW_IRU_ORG_MODEL_GUARANTEE_1_VALIDITY_PERIOD_DURATION_P60D, validityPeriod);
	}
	
	@Test
	public void monetaryLimitSixtyThousandEurosTest() {
		String monetaryLimit = HTTP_WWW_IRU_ORG_MODEL_GUARANTEE_1_MONETARY_LIMIT_VALUE_60000_CURRENCY_EUR;
		Map<String,String> monetaryLimitParams = util.monetaryLimitParameters(monetaryLimit);
		Assert.assertEquals(2, monetaryLimitParams.size());
		Assert.assertEquals(EURO, monetaryLimitParams.get(CURRENCY));
		Assert.assertEquals(SIXTY_THOUSAND, Integer.parseInt(monetaryLimitParams.get(VALUE)));
	}

	@Test
	public void withMonetaryLimitSixtyThousandEurosTest() {
		String  monetaryLimit = util.withMonetaryLimitParameters(EURO, SIXTY_THOUSAND);
		Assert.assertEquals(HTTP_WWW_IRU_ORG_MODEL_GUARANTEE_1_MONETARY_LIMIT_VALUE_60000_CURRENCY_EUR, monetaryLimit);
	}

}
