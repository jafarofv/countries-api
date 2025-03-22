package com.jafarofv.countries_api.service.impl;

import com.jafarofv.countries_api.entity.Country;
import com.jafarofv.countries_api.initializer.CountryInitializer;
import com.jafarofv.countries_api.repository.ICountryRepository;
import com.jafarofv.countries_api.service.interfaces.ICountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService implements ICountryService {
    private final ICountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public List<Country> insertCountries() {
        return countryRepository.saveAll(CountryInitializer.readCountry());
    }
}
