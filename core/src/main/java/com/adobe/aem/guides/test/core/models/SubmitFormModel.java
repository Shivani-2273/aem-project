package com.adobe.aem.guides.test.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SubmitFormModel {
    @SlingObject
    private SlingHttpServletRequest request;

    @ValueMapValue
    private String heading;

    public String getHeading(){ return heading; }


    public String getAction() {
        return request.getResource().getPath() + "/submitForm";
    }




}

