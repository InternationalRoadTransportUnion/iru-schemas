package org.iru.model.guarantee;

import org.junit.Assert;
import org.junit.Test;

public class UsageRuleValueUtilTest {
	
	public UsageRuleValueUtil util = new UsageRuleValueUtil();

	@Test
	public void testTUREUCorridor() {
		 String value = "http://www.iru.org/model/guarantee-1/corridor?type=two-way&countries=TUR,EUE";
		 CorridorParameters cp = util.toCorridorParameters(value);
		 
		 Assert.assertEquals(CorridorTypeParameter.TWO_WAY, cp.getType());
		 Assert.assertEquals(2, cp.getCountries().size());
		 Assert.assertTrue(cp.getCountries().contains("TUR"));
		 Assert.assertTrue(cp.getCountries().contains("EUE"));
	}
	
}
