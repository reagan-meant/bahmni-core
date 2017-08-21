package org.bahmni.module.bahmnicore.contract.drugorder;


import java.util.Locale;

import org.openmrs.Concept;
import org.openmrs.ConceptName;
import org.openmrs.api.context.Context;

public class ConceptData {
    private String name;
    private String rootConcept;

    public ConceptData() {
    }

    public ConceptData(Concept concept) {
        if(concept != null) {
        	this.name = getName(concept, Context.getLocale());; 
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRootConcept() {
        return rootConcept;
    }

    public void setRootConcept(String rootConcept) {
        this.rootConcept = rootConcept;
    }
    
    /**
     * Guesses the name out of a concept.
     * @param concept
     * @param locale
     */
    public static String getName(Concept concept, Locale locale) {
    	// Trying short name then preferred name
    	ConceptName shortName = concept.getShortNameInLocale(locale);
    	return (shortName == null) ? concept.getName(locale).getName() : shortName.getName();
    }
}