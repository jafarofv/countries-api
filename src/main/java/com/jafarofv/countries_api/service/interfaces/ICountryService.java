package com.jafarofv.countries_api.service.interfaces;

import com.jafarofv.countries_api.entity.Country;

import java.util.List;

public interface ICountryService {
    List<Country> getAllCountries();
    List<Country> insertCountries();
}
