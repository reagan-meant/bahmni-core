package org.bahmni.module.bahmnicore.contract.drugorder;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.openmrs.Concept;
import org.openmrs.ConceptName;

public class ConceptDataTest {
	
	@Test
	public void shouldPreferShortNameOverPreferredOverFSN() {
		Locale locale = new Locale("wx_YZ");
		Concept c = new Concept();
		c.setFullySpecifiedName(new ConceptName("fsn", locale));
		Assert.assertEquals("fsn", ConceptData.getName(c, locale));
		c.setPreferredName(new ConceptName("preferred.name", locale));
		Assert.assertEquals("preferred.name", ConceptData.getName(c, locale));
		c.setShortName(new ConceptName("short.name", locale));
		Assert.assertEquals("short.name", ConceptData.getName(c, locale));
	}
}