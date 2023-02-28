package bean_practice.stereotype_annotations.model;

import bean_practice.stereotype_annotations.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {

       ApplicationContext container = new AnnotationConfigApplicationContext(Config.class);

 DataStructure ds=container.getBean(DataStructure.class);
        System.out.println(ds.getTotalHours());
        MicroService microService= container.getBean(MicroService.class);
        System.out.println(microService.getTotalHours());
        ExtraHours extraHours=container.getBean(ExtraHours.class);
        System.out.println(extraHours.getHours());
    }
    }

