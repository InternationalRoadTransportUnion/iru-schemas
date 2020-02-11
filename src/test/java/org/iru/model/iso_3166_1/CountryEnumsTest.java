package org.iru.model.iso_3166_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class CountryEnumsTest {
	
	private static int TIR_CONTRACTING_PARTIES = 75; //https://www.unece.org/tir/welcome.html
	private static int TIR_CP_COUNTRIES = TIR_CONTRACTING_PARTIES - 1 ; // EU is not a country
	
	private static String[] NON_OPERATIONAL_COUNTRIES_JDK_NAMES = { // https://www.unece.org/tir/system/countries.html
			"Algeria",
			"Canada",
			"Chile",
			"Indonesia",
			"Liberia",
			"Oman",
			"Palestine",
			"South Korea",
			"Saudi Arabia",
			"United States",
			"Uruguay"
	};
	
    final static Map<String, Locale> alpha3ToAlpha2;
    final static Map<String, String> alpha2ToAlpha3;

    static {
        String[] countries = Locale.getISOCountries();
        alpha3ToAlpha2 = new HashMap<>(countries.length);
        alpha2ToAlpha3 = new HashMap<>(countries.length);
        for (String country : countries) {
            Locale locale = new Locale("", country);
            alpha3ToAlpha2.put(locale.getISO3Country().toUpperCase(), locale);
            alpha2ToAlpha3.put(country, locale.getISO3Country().toUpperCase());
        }
    }
	
	private static int TIR_OPERATIONAL_COUNTRIES = TIR_CP_COUNTRIES - NON_OPERATIONAL_COUNTRIES_JDK_NAMES.length; 

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

	@Test
	public void diffISO2() {
		List<String> contractingCountries = Arrays.stream(org.iru.model.iso_3166_1_alpha_2.ContractingPartyCountryCodeType.values())
				.map(org.iru.model.iso_3166_1_alpha_2.ContractingPartyCountryCodeType::toString)
				.sorted()
				.collect(Collectors.toList());

		List<String> operationalCountries = Arrays.stream(org.iru.model.iso_3166_1_alpha_2.TIROperationalCountryCodeType.values())
				.map(org.iru.model.iso_3166_1_alpha_2.TIROperationalCountryCodeType::toString)
				.sorted()
				.collect(Collectors.toList());

		{
			List<String> cc2 = new ArrayList<>(contractingCountries);
			cc2.retainAll(operationalCountries);
			Assert.assertEquals(cc2, operationalCountries);
		}
		{
			List<String> nonOperationalCountries = new ArrayList<>(contractingCountries);
			nonOperationalCountries.removeAll(operationalCountries);
			List<String> nonOperationalCountryNames = nonOperationalCountries.stream()
					.map(c -> alpha3ToAlpha2.get(alpha2ToAlpha3.get(c)).getDisplayCountry(Locale.ENGLISH))
					.sorted()
					.collect(Collectors.toList());

			List<String> testData = Arrays.stream(NON_OPERATIONAL_COUNTRIES_JDK_NAMES)
					.sorted()
					.collect(Collectors.toList());
			
			Assert.assertEquals(testData, nonOperationalCountryNames);
		}
	}

	
	@Test
	public void diffISO3() {
		List<String> contractingCountries = Arrays.stream(org.iru.model.iso_3166_1_alpha_3.ContractingPartyCountryCodeType.values())
				.map(org.iru.model.iso_3166_1_alpha_3.ContractingPartyCountryCodeType::toString)
				.sorted()
				.collect(Collectors.toList());

		List<String> operationalCountries = Arrays.stream(org.iru.model.iso_3166_1_alpha_3.TIROperationalCountryCodeType.values())
				.map(org.iru.model.iso_3166_1_alpha_3.TIROperationalCountryCodeType::toString)
				.sorted()
				.collect(Collectors.toList());

		{
			List<String> cc2 = new ArrayList<>(contractingCountries);
			cc2.retainAll(operationalCountries);
			Assert.assertEquals(cc2, operationalCountries);
		}
		{
			List<String> nonOperationalCountries = new ArrayList<>(contractingCountries);
			nonOperationalCountries.removeAll(operationalCountries);
			List<String> nonOperationalCountryNames = nonOperationalCountries.stream()
					.map(c -> alpha3ToAlpha2.get(c).getDisplayCountry(Locale.ENGLISH))
					.sorted()
					.collect(Collectors.toList());

			List<String> testData = Arrays.stream(NON_OPERATIONAL_COUNTRIES_JDK_NAMES)
					.sorted()
					.collect(Collectors.toList());
			
			Assert.assertEquals(testData, nonOperationalCountryNames);
		}
	}
}
