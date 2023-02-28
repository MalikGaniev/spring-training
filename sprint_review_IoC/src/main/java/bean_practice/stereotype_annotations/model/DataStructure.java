package bean_practice.stereotype_annotations.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class DataStructure {

  private final  ExtraHours extraHours;
    public String getTotalHours(){

        return "Total hours: "+(35+extraHours.getHours());
    }

    public DataStructure(ExtraHours extraHours) {
        this.extraHours = extraHours;
    }
}
