package com.jafarofv.countries_api.repository;

import com.jafarofv.countries_api.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends JpaRepository<Country, String> {

}
