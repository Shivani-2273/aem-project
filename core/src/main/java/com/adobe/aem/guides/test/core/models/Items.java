package com.adobe.aem.guides.test.core.models;

import lombok.Getter;
import lombok.Setter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Getter
@Setter
@Model(
        adaptables = {Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class Items {

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String paragraph;

    @ValueMapValue
    private String cta;

    @Self
    private Resource resource;

    public String getImagePath() {
            String fileReference =
              resource.getValueMap().get("fileReference", String.class);
            if (fileReference != null) {
            System.out.println(fileReference);
            return fileReference;
        }

        return null;
    }

}
