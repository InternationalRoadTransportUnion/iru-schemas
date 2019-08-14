package org.iru.model.guarantee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CorridorUtil {

	public boolean validateCustomsOperations(List<String> customsOperationIso3CountryList, CorridorParameters corridor, Map<String, List<String>> customsUnions)  {
		Map<String, List<String>> corridorCustomsUnions = getCorridorCustomsUnions(corridor, customsUnions);
		List<String> updated = replaceWithCustomsUnions(customsOperationIso3CountryList, corridorCustomsUnions);

		switch (corridor.getType()) {
		case ONE_WAY:
			return updated.equals(corridor.getCountries());
		case TWO_WAY:
			return updated.equals(corridor.getCountries()) || reverse(updated).equals(corridor.getCountries());
		}
		
		return false;
	}

	private List<String> reverse(List<String> updated) {
		List<String> copy = new ArrayList<>(updated);
		Collections.reverse(copy);
		return copy;
	}

	private Map<String, List<String>> getCorridorCustomsUnions(CorridorParameters corridor, Map<String, List<String>> customsUnions) {
		Map<String, List<String>> corridorCustomsUnions = new HashMap<>();
		if (customsUnions != null) {
			for (String country : corridor.getCountries()) {
				List<String> cuCountries = customsUnions.get(country);
				if (cuCountries != null) {
					corridorCustomsUnions.put(country, cuCountries);
				}
			}
		}
		return corridorCustomsUnions;
	}
	
	private List<String> replaceWithCustomsUnions(List<String> customsOperationIso3CountryList, Map<String, List<String>> corridorCustomsUnions) {
		List<String> output = new ArrayList<String>();
		String previousCountry = null;
		for (String customsOperationIso3Country : customsOperationIso3CountryList) {
			for (Map.Entry<String, List<String>> me : corridorCustomsUnions.entrySet()) {
				if (me.getValue().contains(customsOperationIso3Country)) {
					customsOperationIso3Country = me.getKey();
					break;
				}
			}
			if (previousCountry == null || ! previousCountry.equals(customsOperationIso3Country)) {
				output.add(customsOperationIso3Country);
				previousCountry = customsOperationIso3Country;
			}
			
		}
		
		return output;
	}

	
}
