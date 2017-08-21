package org.bahmni.module.bahmnicore.contract.drugorder;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.openmrs.Concept;
import org.openmrs.ConceptName;
import org.openmrs.OrderFrequency;

public class OrderFrequencyDataTest {
	
	@Test
	public void shouldPreferShortNameFromUnderlyingConceptNames() {
		Locale locale = new Locale("wx_YZ");
		OrderFrequency of = new OrderFrequency();
		Concept c = new Concept();
		of.setConcept(c);
		c.addName(new ConceptName("name", locale));
		Assert.assertEquals("name", OrderFrequencyData.getName(of, locale));
		c.setShortName(new ConceptName("short.name", locale));
		Assert.assertEquals("short.name", OrderFrequencyData.getName(of, locale));
	}
}