package org.bahmni.module.bahmnicore.web.v1_0.controller;

import java.util.Arrays;
import java.util.List;

import org.bahmni.module.bahmnicore.model.BahmniAddressHierarchyEntry;
import org.bahmni.module.bahmnicore.service.BahmniAddressHierarchyService;
import org.openmrs.messagesource.MessageSourceService;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/rest/" + RestConstants.VERSION_1)
public class BahmniAddressHierarchyController {

    private BahmniAddressHierarchyService bahmniAddressHierarchyService;
    private MessageSourceService messageSourceService;

    @Autowired
    public BahmniAddressHierarchyController(BahmniAddressHierarchyService bahmniAddressHierarchyService, MessageSourceService messageSourceService) {
        this.bahmniAddressHierarchyService = bahmniAddressHierarchyService;
        this.messageSourceService = messageSourceService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addressHierarchy/{uuid}")
    @ResponseBody
    public BahmniAddressHierarchyEntry get(@PathVariable("uuid") String uuid) {
        if (uuid == null) {
            return null;
        }
        BahmniAddressHierarchyEntry bahmniAddressHierarchyEntry = null;
        List<BahmniAddressHierarchyEntry>  addressHierarchyEntries = bahmniAddressHierarchyService.getAddressHierarchyEntriesByUuid(Arrays.asList(uuid));
        if(!addressHierarchyEntries.isEmpty()){
            bahmniAddressHierarchyEntry = addressHierarchyEntries.get(0);
            bahmniAddressHierarchyEntry.setName( messageSourceService.getMessage(bahmniAddressHierarchyEntry.getName()) );
        }
        return bahmniAddressHierarchyEntry;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addressHierarchy")
    @ResponseBody
    public List<BahmniAddressHierarchyEntry> getAddressHierarchyEntriesByUuid(@RequestParam(value = "uuids", required = true) List<String> uuids) {
        if (uuids.isEmpty()) {
            return null;
        }
        return bahmniAddressHierarchyService.getAddressHierarchyEntriesByUuid(uuids);
    }

}
