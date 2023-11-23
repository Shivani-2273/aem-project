package com.adobe.aem.guides.test.core.models.impl;

import com.adobe.aem.guides.test.core.models.Student;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.util.converter.Converters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Random;

@Component(
        service = {Student.class}
//        property = {
//            "activities = Hiking",
//            "activities = Jogging",
//            "activities = Walking",
//            "random.seed:Integer = 10"
//}

)
@Designate(ocd = StudentImpl.Config.class)
public class StudentImpl implements Student {

    public static final Logger log = LoggerFactory.getLogger(StudentImpl.class);


    @ObjectClassDefinition(
            name = "Test Example - Student class",
            description = "Testing description"
    )
    @interface Config{
        @AttributeDefinition(
                name = "Student Activites",
                description = "definition testing"
        )
        String[] activities() default { "Hiking", "Jogging", "Walking" };

        @AttributeDefinition(
                name = "Random Activity Seed",
                description = "Seed used to randomize activity selection"
        )
        int random_seed() default 10;

    }

    private  Random random;
    private String[] activities;
  //  private final Random random = new Random();

//    private static final String[] Activities = new String[]{
//            "Camping", "Skiing",  "Skateboarding"
//    };


    @Override
    public String getfirstName() {
        return "Shivani";
    }

    @Override
    public String lastName() {
        return "Coco";
    }

    @Override
    public String getRandomActivity() {
        int randomIndex = random.nextInt(activities.length);
        return activities[randomIndex];
    }

    @Activate
    protected void activate(Map<String, Object> properties){
        this.activities = Converters.standardConverter()
                .convert(properties.get("activities"))
                        .defaultValue(new String[]{
                                "Default Activity 1",
                                "Default Activity 2"
                        })
                                .to(String[].class);

        final Integer randomSeed = Converters.standardConverter()
                .convert(properties.get("random.seed"))
                        .defaultValue(25)
                                .to(Integer.class);

        this.random = new Random(randomSeed);
//
//        this.activities = new String[]{
//                "Running", "Cycling",  "Skateboarding"
//        };

        log.info("Activated StudentsImpl with activities [ {} ]", String.join(", ", this.activities));;
    }


    //for conf.json file


    @Deactivate
    protected void deactivate(){
        log.info("StudentImpl has been deactivated");
    }
}
