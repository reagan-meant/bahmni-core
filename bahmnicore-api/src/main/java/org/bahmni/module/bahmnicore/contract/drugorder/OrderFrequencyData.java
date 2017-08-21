package org.bahmni.module.bahmnicore.contract.drugorder;

import java.util.Locale;

import org.openmrs.Concept;
import org.openmrs.OrderFrequency;
import org.openmrs.api.context.Context;

public class OrderFrequencyData {

    private String uuid;
    private Double frequencyPerDay;
    private String name;

    public OrderFrequencyData(OrderFrequency orderFrequency) {
        this.setUuid(orderFrequency.getUuid());
        this.setFrequencyPerDay(orderFrequency.getFrequencyPerDay());
        this.setName(getName(orderFrequency, Context.getLocale()));
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setFrequencyPerDay(Double frequencyPerDay) {
        this.frequencyPerDay = frequencyPerDay;
    }

    public Double getFrequencyPerDay() {
        return frequencyPerDay;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public String getName() {
        return name;
    }
    
    /**
     * Guesses the name out of an order frequency.
     * @param orderFrequency
     * @param locale
     */
    public static String getName(OrderFrequency orderFrequency, Locale locale) {
    	Concept concept = orderFrequency.getConcept();
    	if (concept != null) {
    		return ConceptData.getName(concept, locale);
    	}
    	else {
    		return orderFrequency.getName();
    	}
    }
}
