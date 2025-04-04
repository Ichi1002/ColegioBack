package com.colegio.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private long id;
    private String name;
    private String code;

    public com.example.student.Country convertCountry(Country country){
        com.example.student.Country countryS = new com.example.student.Country();
        countryS.setId(country.getId());
        countryS.setName(country.getName());
        countryS.setCode(country.getCode());
        return countryS;
    }
}
