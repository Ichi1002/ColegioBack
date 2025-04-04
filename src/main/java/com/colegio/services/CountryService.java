package com.colegio.services;

import com.colegio.models.Country;
import com.colegio.repository.ICountryRepository;

import com.example.student.GetCountryListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService implements ICountryService{
    private final ICountryRepository countryRepository;

    @Override
    public GetCountryListResponse getAllCountry() {
        List<Country> countryList = countryRepository.getAllCountry();
        GetCountryListResponse response = new GetCountryListResponse();
        countryList.forEach(country -> response.getCountry().add(country.convertCountry(country)));
        return response;
    }
}
