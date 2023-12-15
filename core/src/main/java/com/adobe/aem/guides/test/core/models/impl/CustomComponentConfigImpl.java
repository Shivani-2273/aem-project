package com.adobe.aem.guides.test.core.models.impl;

import com.adobe.aem.guides.test.core.models.CustomComponentConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(
        service = { CustomComponentConfig.class }
)
@Designate(ocd = CustomComponentConfigImpl.Config.class)
public class CustomComponentConfigImpl implements CustomComponentConfig {

    private String firstname;
    private String lastName;

    @Override
    public String firstName() {
        return firstname;
    }

    @Override
    public String lastName() {
        return lastName;
    }

    @ObjectClassDefinition(
            name = "Testing Configuration",
            description = "OSGi Service providing information"
    )
    @interface Config{
        @AttributeDefinition(name = "First Name", description = "Enter the first name.")
        String firstName() default "John";

        @AttributeDefinition(name = "Last Name", description = "Enter the last name.")
        String lastName() default  "Barnett";

    }

    @Activate
    protected void activate(Config config){
        this.firstname = config.firstName();
        this.lastName = config.lastName();
    }



}
