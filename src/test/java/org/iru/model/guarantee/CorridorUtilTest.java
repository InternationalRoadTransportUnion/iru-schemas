package org.iru.model.guarantee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class CorridorUtilTest {
	
	public CorridorUtil util = new CorridorUtil();

	@Test
	public void testTUREUCorridor() {
		 String value = "http://www.iru.org/model/guarantee-1/corridor?type=two-way&countries=TUR,EUE";
		 CorridorParameters cp = new UsageRuleValueUtil().toCorridorParameters(value);

		 Map<String, List<String>> customsUnions = Collections.singletonMap("EUE", 
				 Arrays.asList("AUT", "BEL", "BGR", "CYP", "CZE",
                               "DEU", "DNK", "ESP", "EST", "FIN",
                               "FRA", "GBR", "GRC", "HRV", "HUN",
                               "IRL", "ITA", "LTU", "LUX", "LVA",
                               "MLT", "NLD", "POL", "PRT", "ROU",
                               "SVK", "SVN", "SWE"
                              ));
		 
		 
		 Assert.assertTrue(util.validateCustomsOperations(Arrays.asList("TUR", "BGR"), cp, customsUnions));
		 Assert.assertFalse(util.validateCustomsOperations(Arrays.asList("TUR", "GRC", "ITA", "CHE"), cp, customsUnions));
		 Assert.assertTrue(util.validateCustomsOperations(Arrays.asList("ROU", "BGR", "TUR"), cp, customsUnions));
	}

	@Test
	public void testAZIRCorridor() {
		 String value = "http://www.iru.org/model/guarantee-1/corridor?type=one-way&countries=AZE,IRN";
		 CorridorParameters cp = new UsageRuleValueUtil().toCorridorParameters(value);

		 Map<String, List<String>> customsUnions = Collections.emptyMap();
		 
		 Assert.assertTrue(util.validateCustomsOperations(Arrays.asList("AZE", "IRN"), cp, customsUnions));
		 Assert.assertFalse(util.validateCustomsOperations(Arrays.asList("TUR", "IRN"), cp, customsUnions));
		 Assert.assertFalse(util.validateCustomsOperations(Arrays.asList("IRN", "AZE"), cp, customsUnions));
	}
	
	
}
