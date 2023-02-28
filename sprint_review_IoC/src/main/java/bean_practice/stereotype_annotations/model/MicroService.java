package bean_practice.stereotype_annotations.model;

import org.springframework.stereotype.Component;

@Component
public class MicroService {

    public String getTotalHours(){
        return "Total hours: "+20;
    }
}
