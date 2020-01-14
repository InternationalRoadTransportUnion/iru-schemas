package org.iru.model.guarantee;

import java.util.Map;

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
		 
		 String corridorProp = util.withCorridorParameters(cp);
		 Assert.assertEquals(value, corridorProp);
	}
	
	@Test
	public void testBYEpdTokenWaiver() {
		 String value = "http://www.iru.org/model/guarantee-1/epd-token-waiver?countries=BLR";
		 Map<String, Integer> counts = util.toEpdTokenWaiverCountryCountMap(value);
		 
		 Assert.assertEquals(1, counts.size());
		 Assert.assertTrue(counts.keySet().contains("BLR"));
		 Assert.assertNull(counts.values().iterator().next());
		 
		 String countsProp = util.withEpdTokenWaiver(counts);
		 Assert.assertEquals(value, countsProp);
	}
	
}
