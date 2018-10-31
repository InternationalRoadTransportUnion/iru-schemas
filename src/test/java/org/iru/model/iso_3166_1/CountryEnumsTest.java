package org.iru.model.iso_3166_1;

import org.junit.Assert;
import org.junit.Test;

public class CountryEnumsTest {
	
	private static int TIR_CONTRACTING_PARTIES = 74; //https://www.unece.org/tir/welcome.html
	private static int TIR_CP_COUNTRIES = TIR_CONTRACTING_PARTIES - 1 ; // EU is not a country
	
	private static String[] NON_OPERATIONAL_COUNTRIES = { // https://www.unece.org/tir/system/countries.html
			"Algeria",
			"Canada",
			"Chile",
			"Indonesia",
			"Liberia",
			"Palestine",
			"Republic of Korea",
			"United States of America",
			"Saudi Arabia",
			"Uruguay"
	};
	
	private static int TIR_OPERATIONAL_COUNTRIES = TIR_CP_COUNTRIES - NON_OPERATIONAL_COUNTRIES.length; 

	@Test
	public void checkISO2CPList() {
		Assert.assertEquals(TIR_CP_COUNTRIES, org.iru.model.iso_3166_1_alpha_2.ContractingPartyCountryCodeType.values().length);
	}
	
	@Test
	public void checkISO3CPList() {
		Assert.assertEquals(TIR_CP_COUNTRIES, org.iru.model.iso_3166_1_alpha_3.ContractingPartyCountryCodeType.values().length);
	}

	@Test
	public void checkISO2OpList() {
		Assert.assertEquals(TIR_OPERATIONAL_COUNTRIES, org.iru.model.iso_3166_1_alpha_2.TIROperationalCountryCodeType.values().length);
	}
	
	@Test
	public void checkISO3OpList() {
		Assert.assertEquals(TIR_OPERATIONAL_COUNTRIES, org.iru.model.iso_3166_1_alpha_3.TIROperationalCountryCodeType.values().length);
	}

	
}
