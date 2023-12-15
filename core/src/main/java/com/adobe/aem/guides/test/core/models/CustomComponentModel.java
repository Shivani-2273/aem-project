package com.adobe.aem.guides.test.core.models;

import lombok.Getter;
import lombok.Setter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import java.util.List;

@Model(
        adaptables = {Resource.class},
        resourceType = CustomComponentModel.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Getter
@Setter
@Exporter(name="jackson",extensions = "json",selector = "custom")
public class CustomComponentModel {

    static final String RESOURCE_TYPE="myproject/components/customComponent";

    @ValueMapValue
    private String heading;

    @ValueMapValue
    private String myCheckbox;

    @OSGiService
    CustomComponentConfig customComponentConfig;

    @ChildResource
    List<Items> items;



}
