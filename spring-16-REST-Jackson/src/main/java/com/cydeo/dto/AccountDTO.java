package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"city","age","postalCode"})
public class AccountDTO {

    private String name;
    private String address;
    private String country;
    private String state;

    private String city;

    private Integer age;

    private String postalCode;

    @JsonBackReference //this field will not be serialized
    private UserDTO user;

}
