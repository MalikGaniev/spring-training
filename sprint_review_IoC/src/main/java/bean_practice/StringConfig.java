package bean_practice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringConfig {
    @Bean(name = "str1")
    public String Welcome(){
        return "Welcome to Cydeo App";
    }
    @Bean(name = "str2")
    public String Core(){
        return "We Working on Sprint Core";
    }
}
