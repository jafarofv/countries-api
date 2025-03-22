package com.jafarofv.countries_api.controller;

import com.jafarofv.countries_api.entity.Country;
import com.jafarofv.countries_api.service.impl.CountryService;
import com.jafarofv.countries_api.util.constants.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Api.Country.BASE_URL)
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public List<Country> getCountries() {
        return countryService.getAllCountries();
    }

    @PostMapping(Api.Country.INSERT_ALL)
    public List<Country> insertCountries() {
        return countryService.insertCountries();
    }

}
